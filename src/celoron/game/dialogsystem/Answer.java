package celoron.game.dialogsystem;

import javax.script.Invocable;

import celoron.game.map.MapObject;
import celoron.game.TheGame;

/**
 * Oyuncu tarafýndan konuþulabilen kýsýmlar
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
	 * Verilen npc ye göre bu dialogun oyuncu tarafýndan konuþulup konuþulamayacaðýna
	 * karar verir
	 * @param player: oyuncunun harita objesi
	 * @param other: konuþulan npc nin harita objesi
	 * @return kullanýcý tarafýndan konuþulabilir mi?
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
	 * Oyuncunun söyleyeceði texti üreten fonksiyon
	 * @param player: oyuncunun harita objesi
	 * @param other: konuþulan npc nin harita objesi
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
	 * Oyuncu bu dialogu aktifleþtirirse çalýþan fonksiyon
	 * @param player: oyuncunun harita objesi
	 * @param other: konuþulan npc nin harita objesi
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
