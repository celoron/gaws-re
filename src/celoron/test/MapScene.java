package celoron.test;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Vector2f;

public class MapScene {
	List<MapObject> objects= new ArrayList<MapObject>();
	
	Vector2f camPos= new Vector2f(0,0);
	
	public MapScene(){
		
	}
	
	public void add(MapObject obj){
		objects.add(obj);
	}
	
	public void renderAll(){
        for(MapObject obj : objects){
			obj.render();
        }
	}
	
	public void updateAll(){
        for(MapObject obj : objects){
			obj.update();
        }
	}
}
