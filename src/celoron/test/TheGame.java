package celoron.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import celoron.game.dialogsystem.Answer;
import celoron.game.dialogsystem.Dialogs;
import celoron.game.map.MapImages;
import celoron.gui.Gui;
  
public class TheGame extends StateBasedGame{
	
	public static int MENU_STATE= 0;
	public static int MAP_STATE= 1;
	public static int DIALOG_STATE= 2;
	
	public static MapImages mapImages;
	public static Dialogs dialogs;
	public static DialogState dialog;
	
	public static ScriptEngine script;
	
    public TheGame() {
        super("Testing..");
        
        mapImages= new MapImages("data/images.xml");
        
        dialogs= new Dialogs();
        dialogs.load("data/dialogs.xml");
        
        ScriptEngineManager factory = new ScriptEngineManager();
        script = factory.getEngineByName("JavaScript");

        
        addState(new MenuState(MENU_STATE));
        addState(new MapState(MAP_STATE));
        addState(dialog=new DialogState(DIALOG_STATE));
        enterState(MENU_STATE);
    }

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
        Gui.input= gc.getInput();
        
		//getState(MENU_STATE).init(gc, this);
		//getState(MAP_STATE).init(gc, this);
	}
  
    public static void main(String[] args) throws SlickException {
         AppGameContainer app =
            new AppGameContainer( new TheGame() );
  
         app.setDisplayMode(800, 600, false);
         app.start();
    }
}