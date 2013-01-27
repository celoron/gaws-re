package celoron.test;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class MapObject {
	Image img;
	Vector2f pos;
	float rot;
	
	public MapObject(Image img, Vector2f pos){
		this.img= img;
		setPosition(pos);
		setRot(0);
	}
	
	public void setPosition(Vector2f pos){
		this.pos= pos;
	}
	
	public Vector2f getPosition(){
		return pos;
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
}
