package celoron.game.dialogsystem;

import javax.script.Invocable;

import celoron.game.map.MapObject;
import celoron.test.TheGame;

public class Answer {
	public String id;
	public String did;
	String f;
	
	public Answer(String id, String did, String f){
		this.id=id;
		this.did=did;
		this.f=f;
	}
	
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
	
	public void action(MapObject player, MapObject other){
		try {
			TheGame.script.eval(f);
			((Invocable) TheGame.script).invokeFunction("action", player, other);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
