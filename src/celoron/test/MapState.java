package celoron.test;

import java.util.List;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import celoron.game.dialogsystem.Answer;
import celoron.game.map.MapObject;
import celoron.game.map.MapObjectMoveable;
import celoron.game.map.MapScene;
import celoron.game.map.query.MapQuery;
import celoron.game.map.query.MapQueryRangeFilter;
import celoron.game.map.query.MapQuerySingleObjectFilter;
import celoron.gui.GuiLayout;
import celoron.gui.GuiLayoutVertical;
import celoron.gui.GuiStyle;

public class MapState extends BasicGameState {
	int id;
	
	MapObjectMoveable ship= null;
	MapScene mscene;
	
	GuiStyle label, button;
	
	public MapState(int id){
		this.id=id;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		mscene= new MapScene(gc);
		
		label= new GuiStyle(new Image("data/btn_back.png"));
		label.setBorders(3, 3, 3, 3);
		label.setPaddings(10, 10, 8, 8);
		label.setMargins(0, 0, 0, 5);
		label.setFont("data/myriad.OTF", 20);

		button= new GuiStyle(new Image("data/btn_back2.png"));
		button.setHoverImage(new Image("data/btn_back_hover2.png"));
		button.setBorders(3, 3, 3, 3);
		button.setPaddings(6, 6, 4, 4);
		button.setFont("data/myriad.OTF", 18);
		
		//set global value for scripting
		TheGame.script.put("map", mscene);
		
		//load map from xml file
		mscene.load("data/map.xml");

		//create player manually. note:going to change
		ship= new MapObjectMoveable(new Image("data/ship1.png"), new Vector2f(0, 0), 2.5f);
		mscene.add(ship);
		
		//example of setting mapobject's value.
		ship.value("gold", 2000);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		mscene.renderAll();
		
		GuiLayout layout= new GuiLayoutVertical(500, 20);
		layout.draw(label, "Gold: "+ ship.valueInt("gold") );
		layout.draw(label, "Move by right mouse click.. ");
		
		MapQuery q= new MapQuery(mscene);
		List<MapObject> mobjs= 
				q
				.filter(new MapQueryRangeFilter(ship.getPosition(), 75))
				.filter(new MapQuerySingleObjectFilter(ship))
				.list();
		
		for(MapObject mobj : mobjs){
			Vector2f spos= mscene.getScreenPosition(mobj);
			if(button.draw(mobj.valueStr("name"), spos.x, spos.y, true)){
				//start dialog
				TheGame.dialog.setDialog(mobj.getInteract(), ship, mobj);
				sbg.enterState(TheGame.DIALOG_STATE);
			}
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		
		Input input= gc.getInput();
		if(input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)){
			Vector2f target= mscene.getWorldPosRelMouse();
			
			ship.setTarget(target);
			ship.lookAt(target);
		}

		mscene.setCamPos(ship.getPosition());
		mscene.updateAll();
	}

	@Override
	public int getID() {
		return id;
	}

}
