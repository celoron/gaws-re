import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import celoron.gui.Gui;
  
public class TheGame extends StateBasedGame{
  
    public TheGame() {
        super("Testing..");
        
        addState(new MenuState(0));
        enterState(0);
    }

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
        Gui.input= gc.getInput();
        
		getState(0).init(gc, this);
	}
  
    public static void main(String[] args) throws SlickException {
         AppGameContainer app =
            new AppGameContainer( new TheGame() );
  
         app.setDisplayMode(800, 600, false);
         app.start();
    }
}