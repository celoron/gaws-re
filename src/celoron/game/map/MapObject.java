package celoron.game.map;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class MapObject {
	Image img;
	Vector2f pos;
	float rot;
	
	Map<String, Object> values;
	
	String interact;
	
	public MapObject(Image img, Vector2f pos){
		this.img= img;
		setPosition(pos);
		setRot(0);
		
		values= new HashMap<String, Object>();
	}
	
	public void setPosition(Vector2f pos){
		this.pos= pos;
	}
	
	public Vector2f getPosition(){
		return pos.copy();
	}
	
	public void setRot(float rot){
		this.rot= rot;
		img.setRotation(rot);
	}
	
	public float getRot(){
		return rot;
	}
	
	public void update(){
		
	}
	
	public void render(Vector2f camPos){
		img.drawCentered(pos.x - camPos.x, pos.y - camPos.y);
	}
	
	public void setInteract(String interact){
		this.interact= interact;
	}
	
	public String getInteract(){
		return interact;
	}
	
	public Object value(String name){
		return values.get(name);
	}
	
	public String valueStr(String name){
		if(!have(name))return "";
		//TODO: script debugging
		return values.get(name).toString();
	}
	
	public int valueInt(String name){
		if(!have(name))return 0;
		//TODO: script debugging
		return (int)valueFloat(name);
	}
	
	public float valueFloat(String name){
		if(!have(name))return 0;
		//TODO: script debugging
		return Float.parseFloat(valueStr(name));
	}
	
	public boolean valueBool(String name){
		if(!have(name))return false;
		//TODO: script debugging
		return valueStr(name).equals("true");
	}
	
	public boolean have(String name){
		return values.containsKey(name);
	}
	
	public void value(String name, Object value){
		values.put(name, value);
	}
}
