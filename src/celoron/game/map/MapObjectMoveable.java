package celoron.game.map;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class MapObjectMoveable extends MapObject {
	float speed;
	Vector2f target=null;
	
	public MapObjectMoveable(Image img, Vector2f pos, float speed) {
		super(img, pos);
		
		this.speed= speed;
	}
	
	public void setTarget(Vector2f target){
		this.target= target;
	}
	
	public Vector2f getTarget(){
		return target;
	}
	
	public void lookAt(Vector2f target){
		Vector2f v= target.copy().sub(getPosition());
		float angle = 180 - (float)Math.toDegrees(Math.atan2(v.x, v.y));
		setRot(angle);
	}
	
	@Override
	public void update(){
		if(target!=null){
			if( target.distance(getPosition()) > speed ){
				Vector2f diff= target.copy().sub(getPosition()).normalise().scale(speed);
				setPosition(getPosition().add(diff));
			}
			else{
				setPosition(target);
				target=null;
			}
		}
	}
}
