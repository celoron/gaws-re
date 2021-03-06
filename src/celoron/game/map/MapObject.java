package celoron.game.map;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import celoron.game.basics.GameObject;

/**
 * Map tarafından kullanılan objeler. transforma ve bir imaja sahiptirler
 * Oyuncu tarafından etkileşime geçilebilirler.
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
	 * objenin pozisonunu değiştirir
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
	 * rotasyon ataması. (derece, radyan değil)
	 * @param rot
	 */
	public void setRot(float rot){
		this.rot= rot;
		img.setRotation(rot);
	}
	
	/**
	 * objenin rotasyonu. (derece, radyan değil)
	 * @return
	 */
	public float getRot(){
		return rot;
	}
	
	/**
	 * Bu fonksiyonu ne yaptığınızı bilmiyorsanız çağırmayın.
	 * @param delta
	 */
	public void update(float delta){
		
	}

	/**
	 * Bu fonksiyonu ne yaptığınızı bilmiyorsanız çağırmayın.
	 * @param delta
	 */
	public void render(Vector2f camPos){
		int w= img.getWidth();
		int h= img.getHeight();
		
		w=64;
		h=64;
		
		img.draw(pos.x - camPos.x - w/2, pos.y - camPos.y - h/2, w, h);
		
		//img.drawCentered(pos.x - camPos.x, pos.y - camPos.y);
	}
	
	/**
	 * Oyuncu etkileşime geçtiği zaman hangi dialog un başlatılacağını atar
	 * @param interact
	 */
	public void setInteract(String interact){
		this.interact= interact;
	}

	/**
	 * Oyuncu etkileşime geçtiği zaman hangi dialog un başlatılacağını verir
	 * @param interact
	 */
	public String getInteract(){
		return interact;
	}

}
