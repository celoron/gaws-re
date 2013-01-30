package celoron.game.map;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import celoron.game.basics.GameObject;

/**
 * Map tarafýndan kullanýlan objeler. transforma ve bir imaja sahiptirler
 * Oyuncu tarafýndan etkileþime geçilebilirler.
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
	 * objenin pozisonunu deðiþtirir
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
	 * rotasyon atamasý. (derece, radyan deðil)
	 * @param rot
	 */
	public void setRot(float rot){
		this.rot= rot;
		img.setRotation(rot);
	}
	
	/**
	 * objenin rotasyonu. (derece, radyan deðil)
	 * @return
	 */
	public float getRot(){
		return rot;
	}
	
	/**
	 * Bu fonksiyonu ne yaptýðýnýzý bilmiyorsanýz çaðýrmayýn.
	 * @param delta
	 */
	public void update(float delta){
		
	}

	/**
	 * Bu fonksiyonu ne yaptýðýnýzý bilmiyorsanýz çaðýrmayýn.
	 * @param delta
	 */
	public void render(Vector2f camPos){
		img.drawCentered(pos.x - camPos.x, pos.y - camPos.y);
	}
	
	/**
	 * Oyuncu etkileþime geçtiði zaman hangi dialog un baþlatýlacaðýný atar
	 * @param interact
	 */
	public void setInteract(String interact){
		this.interact= interact;
	}

	/**
	 * Oyuncu etkileþime geçtiði zaman hangi dialog un baþlatýlacaðýný verir
	 * @param interact
	 */
	public String getInteract(){
		return interact;
	}

}
