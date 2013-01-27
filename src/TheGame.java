import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import celoron.gui.Gui;
import celoron.test.MapState;
  
public class TheGame extends StateBasedGame{
	
	public static int MENU_STATE= 0;
	public static int MAP_STATE= 1;
  
    public TheGame() {
        super("Testing..");
        
        addState(new MenuState(MENU_STATE));
        addState(new MapState(MAP_STATE));
        enterState(MENU_STATE);
    }

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
        Gui.input= gc.getInput();
        
		getState(MENU_STATE).init(gc, this);
		//getState(MAP_STATE).init(gc, this);
	}
  
    public static void main(String[] args) throws SlickException {
         AppGameContainer app =
            new AppGameContainer( new TheGame() );
  
         app.setDisplayMode(800, 600, false);
         app.start();
    }
}