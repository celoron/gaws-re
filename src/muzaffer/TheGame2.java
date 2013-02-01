package muzaffer;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class TheGame2 extends StateBasedGame {
	
	public TheGame2() {
        super("Test Muzaffer");
/*final*/
        
        addState(new Scene());
        enterState(0);
    }

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
	}
  
    public static void main(String[] args) throws SlickException {

         AppGameContainer app = new AppGameContainer(new TheGame2()) ;
  
         app.setDisplayMode(800, 600, false);
         app.start();
    }
}
