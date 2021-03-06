package celoron.game.dialogsystem;

import javax.script.Invocable;

import celoron.game.map.MapObject;
import celoron.game.TheGame;

/**
 * NPC ler tarafından konuşulabilen kısımlar.
 * @author celoron
 *
 */
public class Dialog {
	String id;
	String f;
	
	public Dialog(String id, String f){
		this.id=id;
		this.f=f;
	}
	
	/**
	 * NPC nin söyleyeceği texti üreten fonksiyon
	 * @param player: oyuncunun harita objesi
	 * @param other: konuşulan npc nin harita objesi
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
}
