package celoron.test;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

public class MapScene {
	GameContainer gc;
	List<MapObject> objects= new ArrayList<MapObject>();
	
	Vector2f camPos= new Vector2f(0,0);
	
	public MapScene(GameContainer gc){
		this.gc=gc;
	}
	
	public void add(MapObject obj){
		objects.add(obj);
	}
	
	public void setCamPos(Vector2f pos){
		camPos= pos.copy().sub(new Vector2f(gc.getWidth()/2, gc.getHeight()/2));
	}
	
	public Vector2f getCamPos(){
		return camPos;
	}
	
	public Vector2f getWorldPosRelMouse(){
		Input input= gc.getInput();
		Vector2f m= new Vector2f(input.getMouseX(), input.getMouseY()).add(camPos);
		
		return m;
	}
	
	public void renderAll(){
        for(MapObject obj : objects){
			obj.render(camPos);
        }
	}
	
	public void updateAll(){
        for(MapObject obj : objects){
			obj.update();
        }
	}
}
