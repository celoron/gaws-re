package celoron.game.map;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import celoron.test.TheGame;


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
	
	public void remove(MapObject obj){
		objects.remove(obj);
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
	
	public Vector2f getScreenPosition(MapObject obj){
		return obj.getPosition().sub(camPos);
	}
	
	public MapObject findClosestInRange(Vector2f origin, float range, MapObject except){
		float closestDist= Float.MAX_VALUE;
		MapObject closest=null;
        for(MapObject obj : objects){
        	float cd= obj.getPosition().sub(origin).lengthSquared();
			if(obj!=except &&  cd< closestDist){
				closest= obj;
				closestDist= cd;
			}
			
        }
        
        if(closest!=null && closest.getPosition().sub(origin).length() < range){
        	return closest;
        }
        return null;
	}
	
	public void load(String path){
		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList ntypes = doc.getElementsByTagName("mobj");
			for (int i = 0; i < ntypes.getLength(); i++) {
				MapObject mobj=null;
				
				Element e = (Element) ntypes.item(i);
				
				String name= e.getAttribute("name");
				String type= e.getAttribute("type");
				String image= e.getAttribute("image");
				
				float x= Float.parseFloat(e.getAttribute("x"));
				float y= Float.parseFloat(e.getAttribute("y"));
				
				if(type.equals("fixed")){
					mobj= new MapObject(TheGame.mapImages.getImage(image), new Vector2f(x,y));
				}
				
				if(mobj!=null){
					mobj.value("name", name);
					add(mobj);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
