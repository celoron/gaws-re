package celoron.game.map;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import celoron.game.basics.GameObject;

/**
 * Map taraf�ndan kullan�lan objeler. transforma ve bir imaja sahiptirler
 * Oyuncu taraf�ndan etkile�ime ge�ilebilirler.
 * @author celoron
 *
 */
public class MapObject extends GameObject{
	Image img;
	Vector2f pos;
	float rot;
	
	String interact;
	
	/**
	 * 
	 * @param img imaj
	 * @param pos haritadaki pozisyonu
	 */
	public MapObject(Image img, Vector2f pos){
		this.img= img;
		setPosition(pos);
		setRot(0);
	}
	
	/**
	 * objenin pozisonunu de�i�tirir
	 * @param pos
	 */
	public void setPosition(Vector2f pos){
		this.pos= pos;
	}
	
	/**
	 * objenin haritadaki posizyonu
	 * @return
	 */
	public Vector2f getPosition(){
		return pos.copy();
	}
	
	/**
	 * rotasyon atamas�. (derece, radyan de�il)
	 * @param rot
	 */
	public void setRot(float rot){
		this.rot= rot;
		img.setRotation(rot);
	}
	
	/**
	 * objenin rotasyonu. (derece, radyan de�il)
	 * @return
	 */
	public float getRot(){
		return rot;
	}
	
	/**
	 * Bu fonksiyonu ne yapt���n�z� bilmiyorsan�z �a��rmay�n.
	 * @param delta
	 */
	public void update(float delta){
		
	}

	/**
	 * Bu fonksiyonu ne yapt���n�z� bilmiyorsan�z �a��rmay�n.
	 * @param delta
	 */
	public void render(Vector2f camPos){
		img.drawCentered(pos.x - camPos.x, pos.y - camPos.y);
	}
	
	/**
	 * Oyuncu etkile�ime ge�ti�i zaman hangi dialog un ba�lat�laca��n� atar
	 * @param interact
	 */
	public void setInteract(String interact){
		this.interact= interact;
	}

	/**
	 * Oyuncu etkile�ime ge�ti�i zaman hangi dialog un ba�lat�laca��n� verir
	 * @param interact
	 */
	public String getInteract(){
		return interact;
	}

}
