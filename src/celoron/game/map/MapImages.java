package celoron.game.map;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.newdawn.slick.Image;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Haritadaki objelerin imaj dosyalarýnýn isimlerinin ve resimlerin yerlerini tutar
 * @author celoron
 *
 */
public class MapImages {
	Map<String, String> images;
	
	public MapImages(){
		images= new HashMap<String, String>();
		
	}
	
	/**
	 * verilen yerdeki dosyadan imaj lari yükler.
	 * not:imaj dosyalarýnýn kendileri yüklenmez
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

			NodeList ntypes = doc.getElementsByTagName("image");
			for (int i = 0; i < ntypes.getLength(); i++) {
				Element e = (Element) ntypes.item(i);
				
				images.put(e.getAttribute("name"), e.getAttribute("path"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ismi verilen imajý yükler ve return eder.
	 * @param name
	 * @return
	 */
	public Image getImage(String name){
		Image img= null;
		
		try {
			img= new Image(images.get(name));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return img;
	}
}
