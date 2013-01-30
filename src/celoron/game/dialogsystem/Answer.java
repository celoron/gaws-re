package celoron.game.dialogsystem;

import javax.script.Invocable;

import celoron.game.map.MapObject;
import celoron.game.TheGame;

/**
 * Oyuncu taraf�ndan konu�ulabilen k�s�mlar
 * @author celoron
 *
 */
public class Answer {
	public String id;
	public String did;
	String f;
	
	public Answer(String id, String did, String f){
		this.id=id;
		this.did=did;
		this.f=f;
	}
	
	/**
	 * Verilen npc ye g�re bu dialogun oyuncu taraf�ndan konu�ulup konu�ulamayaca��na
	 * karar verir
	 * @param player: oyuncunun harita objesi
	 * @param other: konu�ulan npc nin harita objesi
	 * @return kullan�c� taraf�ndan konu�ulabilir mi?
	 */
	public boolean req(MapObject player, MapObject other){
		boolean r= false;
		try {
			TheGame.script.eval(f);
			r= (boolean) ((Invocable) TheGame.script).invokeFunction("req", player, other);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * Oyuncunun s�yleyece�i texti �reten fonksiyon
	 * @param player: oyuncunun harita objesi
	 * @param other: konu�ulan npc nin harita objesi
	 * @return
	 */
	public String text(MapObject player, MapObject other){
		String t= "error";
		try {
			TheGame.script.eval(f);
			t= (String)((Invocable) TheGame.script).invokeFunction("text", player, other);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * Oyuncu bu dialogu aktifle�tirirse �al��an fonksiyon
	 * @param player: oyuncunun harita objesi
	 * @param other: konu�ulan npc nin harita objesi
	 */
	public void action(MapObject player, MapObject other){
		try {
			TheGame.script.eval(f);
			((Invocable) TheGame.script).invokeFunction("action", player, other);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
