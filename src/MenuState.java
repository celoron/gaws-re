import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import celoron.gui.GuiLayout;
import celoron.gui.GuiLayoutHorizontal;
import celoron.gui.GuiStyle;


public class MenuState extends BasicGameState {
	int id;
	
	Image button= null;
	
	GuiStyle style;
	GuiStyle label;
	
	boolean toggle= false;
	
	public MenuState(int id){
		this.id=id;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {

		style= new GuiStyle(new Image("data/btn_back2.png"));
		style.setHoverImage(new Image("data/btn_back_hover2.png"));
		style.setBorders(3, 3, 3, 3);
		style.setPaddings(10, 10, 8, 8);
		style.setFont("data/myriad.OTF", 20);

		label= new GuiStyle(new Image("data/btn_back.png"));
		label.setBorders(3, 3, 3, 3);
		label.setPaddings(10, 10, 8, 8);
		label.setFont("data/myriad.OTF", 20);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		GuiLayout layout= new GuiLayoutHorizontal(200, 40);
		
		layout.draw(label, "Test Scene");
		if(layout.draw(style, "Click me")){
			toggle= !toggle;
		}
		
		if(toggle && layout.draw(style, "And me")){
			sbg.enterState(TheGame.MAP_STATE);
		}
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		
	}

	@Override
	public int getID() {
		return id;
	}

}
