package celoron.game.map;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * Hareket ettirilebilen harita objesi.
 * hareket ettirmekten kasýt, frame e baðlantýlý þekilde
 * belli bir hedefe doðru belirlenen hýzda hareket etmesi.
 * @author celoron
 *
 */
public class MapObjectMoveable extends MapObject {
	float speed;
	Vector2f target=null;
	
	/**
	 * 
	 * @param img imaj
	 * @param pos haritadaki pozisyon
	 * @param speed hýz
	 */
	public MapObjectMoveable(Image img, Vector2f pos, float speed) {
		super(img, pos);
		
		this.speed= speed;
	}
	
	/**
	 * Hedef atamsý
	 * @param target
	 */
	public void setTarget(Vector2f target){
		this.target= target;
	}
	
	/**
	 * Objenin hedefini verir
	 * @return
	 */
	public Vector2f getTarget(){
		return target;
	}
	
	/**
	 * Objenin belli bir pozisyona bakmasý saðlanýr.
	 * dikkat: ön yön resmin yukarýsýdýr.
	 * @param target
	 */
	public void lookAt(Vector2f target){
		Vector2f v= target.copy().sub(getPosition());
		float angle = 180 - (float)Math.toDegrees(Math.atan2(v.x, v.y));
		setRot(angle);
	}
	
	@Override
	public void update(float delta){
		if(target!=null){
			if( target.distance(getPosition()) > speed*delta ){
				Vector2f diff= target.copy().sub(getPosition()).normalise().scale(speed).scale(delta);
				setPosition(getPosition().add(diff));
			}
			else{
				setPosition(target);
				target=null;
			}
		}
	}
}
