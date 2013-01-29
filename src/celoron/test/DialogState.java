package celoron.test;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import celoron.game.dialogsystem.Answer;
import celoron.game.dialogsystem.AnswerRendered;
import celoron.game.dialogsystem.Dialog;
import celoron.game.map.MapObject;
import celoron.gui.GuiLayout;
import celoron.gui.GuiLayoutVertical;
import celoron.gui.GuiStyle;

public class DialogState extends BasicGameState  {
	int id;
	
	GuiStyle label, button;
	
	String npcText;
	List<AnswerRendered> answers;
	
	MapObject player, other;
	
	boolean onDialog=false;
	
	public DialogState(int id){
		this.id=id;
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		label= new GuiStyle(new Image("data/lbl_back.png"));
		label.setBorders(7, 3, 3, 3);
		label.setPaddings(10, 10, 8, 8);
		label.setMargins(0, 0, 0, 5);
		label.setMinWidth(500);
		label.setFont("data/myriad.OTF", 20);

		button= new GuiStyle(new Image("data/btn_back.png"));
		button.setHoverImage(new Image("data/btn_back_hover.png"));
		button.setBorders(3, 3, 3, 3);
		button.setPaddings(10, 10, 6, 6);
		button.setMargins(0, 0, 0, 3);
		button.setMinWidth(500);
		button.setFont("data/myriad.OTF", 20);
		
		TheGame.script.put("dialog", this);
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		

		GuiLayout layout= new GuiLayoutVertical(100, 100);
		layout.draw(label, npcText);
		
		layout.space(20);
		
		for(AnswerRendered a: answers){
			if(layout.draw(button, a.text())){
				a.action(player, other);
			}
		}
		if(layout.draw(button, "[Leave]")){
			leave();
		}
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame sbg, int arg2)
			throws SlickException {
		
		if(!onDialog){
			sbg.enterState(TheGame.MAP_STATE);
		}
	}
	
	public void setDialog(String name, MapObject player, MapObject other){
		onDialog=true;
		
		this.player= player;
		this.other= other;
		
		Dialog d= TheGame.dialogs.getDialog(name);
		if(d==null){
			//TODO: script debugging
		}
		npcText= d.text(player, other);
		
		answers= new ArrayList<AnswerRendered>();
		for(Answer a: TheGame.dialogs.getAnswers(name)){
			if(a.req(player, other))
				answers.add(new AnswerRendered(a, player, other));
		}
	}
	
	public void go(String name){
		setDialog(name, player, other);
	}
	
	public void leave(){
		onDialog=false;
	}

	@Override
	public int getID() {
		return id;
	}

}
