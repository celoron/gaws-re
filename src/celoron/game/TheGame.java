package celoron.game;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import celoron.game.dialogsystem.Dialogs;
import celoron.game.map.MapImages;
import celoron.game.states.StateDialog;
import celoron.game.states.StateMap;
import celoron.game.states.StateMenu;
import celoron.gui.Gui;
import celoron.gui.Notification;

/**
 * TheGame. One class to rule them all!
 * Basitçe bu sýnýf herþeyden sorumlu.
 * @author celoron
 *
 */
public class TheGame extends StateBasedGame {

	public static int MENU_STATE = 0;
	public static int MAP_STATE = 1;
	public static int DIALOG_STATE = 2;

	/**
	 * imaj dosyalarýný bu sýnýftan isteyebilirsiniz.
	 */
	public static MapImages mapImages;
	
	/**
	 * dialog bilgilerini burdan öðrenebilirsiniz.
	 */
	public static Dialogs dialogs;
	
	/**
	 * dialog bilgisinden çok, o anki aktif dialogla ilgilenir.
	 * bu sýnýf aracýlýðýyla yeni dialog baþlatabilirsiniz.
	 */
	public static StateDialog dialog;
	
	/**
	 * Notificationlarý yöneten sýnýf
	 */
	public static Notification notification;

	/**
	 * Bu sýnýf itediðiniz js leri derleyebilir, istediðiniz
	 * fonksiyonu çaðýrabilir, istediðiniz deðerlere ulaþabilir
	 * ve deðiþtirebilirsiniz.
	 */
	public static ScriptEngine script;

	public TheGame() {
		super("Testing..");

		
		mapImages = new MapImages();
		mapImages.load("data/images.xml");

		dialogs = new Dialogs();
		dialogs.load("data/dialogs.xml");

		ScriptEngineManager factory = new ScriptEngineManager();
		script = factory.getEngineByName("JavaScript");

		addState(new StateMenu(MENU_STATE));
		addState(new StateMap(MAP_STATE));
		addState(dialog = new StateDialog(DIALOG_STATE));
		enterState(MENU_STATE);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		notification = new Notification();

		gc.setVSync(true);

		Gui.input = gc.getInput();
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new TheGame());

		app.setDisplayMode(800, 600, false);
		app.start();
	}
}