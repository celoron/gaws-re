package celoron.game.map;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import celoron.game.TheGame;

/**
 * Harita objelerini yükleme, tutma, update etme ver render
 * etme iþini yüklenen sýnýf.
 * @author celoron
 *
 */
public class MapScene {
	GameContainer gc;
	List<MapObject> objects= new ArrayList<MapObject>();
	
	Vector2f camPos= new Vector2f(0,0);
	
	/**
	 * GameContainer verilerek construct edilir.
	 * @param gc
	 */
	public MapScene(GameContainer gc){
		this.gc=gc;
	}
	
	/**
	 * Haritaya yeni harita objesi ekleme
	 * @param obj
	 */
	public void add(MapObject obj){
		objects.add(obj);
	}
	
	/**
	 * Verilen harita objesini haritadan siler
	 * @param obj
	 */
	public void remove(MapObject obj){
		objects.remove(obj);
	}
	
	/**
	 * Kamera posizyonunu atar
	 * @param pos Ekranýn orta noktasýnýn haritanýn neresine bakmasý isteniyorsa
	 */
	public void setCamPos(Vector2f pos){
		camPos= pos.copy().sub(new Vector2f(gc.getWidth()/2, gc.getHeight()/2));
	}
	
	/**
	 * Kamera posizyonunu verir
	 * @return
	 */
	public Vector2f getCamPos(){
		return camPos;
	}
	
	/**
	 * Objelerin hepsini çizer. Fazla elleme
	 */
	public void renderAll(){
        for(MapObject obj : objects){
			obj.render(camPos);
        }
	}

	/**
	 * Objelerin hepsini update eder. Fazla elleme
	 */
	public void updateAll(float delta){
        for(MapObject obj : objects){
			obj.update(delta);
        }
	}
	
	/**
	 * Farenin haritada hangi noktaya geldiðini verir
	 * @return
	 */
	public Vector2f getWorldPosRelMouse(){
		Input input= gc.getInput();
		Vector2f m= new Vector2f(input.getMouseX(), input.getMouseY()).add(camPos);
		
		return m;
	}
	
	/**
	 * Objenin ekranýn hangi pozisyonuna geldiðini verir
	 * @param obj
	 * @return
	 */
	public Vector2f getScreenPosition(MapObject obj){
		return obj.getPosition().sub(camPos);
	}
	
	/**
	 * Haritadaki bütün objeleri liste halinde verir
	 * Listeyi manüpüle etme. Direk liste verilmekte
	 * @return
	 */
	public List<MapObject> getAll(){
		return objects;
	}
	
	/**
	 * Verilen dosyadaki harita objelerini yükler
	 * @param path
	 */
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
				String interact= e.getAttribute("interact");
				
				float x= Float.parseFloat(e.getAttribute("x"));
				float y= Float.parseFloat(e.getAttribute("y"));
				
				if(type.equals("fixed")){
					mobj= new MapObject(TheGame.mapImages.getImage(image), new Vector2f(x,y));
				}
				
				mobj.setInteract(interact);
				
				NodeList values = e.getElementsByTagName("value");
				for (int j = 0; j < values.getLength(); j++) {
					Element value = (Element) values.item(j);
					
					String vname= value.getAttribute("name");
					String vvalue= value.getAttribute("value");
					
					mobj.value(vname, vvalue);
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
