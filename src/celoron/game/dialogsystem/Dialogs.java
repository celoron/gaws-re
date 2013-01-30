package celoron.game.dialogsystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Bütün dialoglarý yükleyen, tutan ve ihtiyaç anýnda veren sýnýf
 * @author celoron
 *
 */
public class Dialogs {
	List<Dialog> dialogs;
	List<Answer> answers;
	
	public Dialogs(){
		dialogs= new ArrayList<Dialog>();
		answers= new ArrayList<Answer>();
	}
	
	/**
	 * Verilen dosayadaki dialoglarý yükler
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

			NodeList ntypes = doc.getElementsByTagName("dialog");
			for (int i = 0; i < ntypes.getLength(); i++) {
				Element e = (Element) ntypes.item(i);
				
				String id= e.getAttribute("id");
				String f= e.getTextContent();
				
				Dialog d= new Dialog(id, f);
				
				dialogs.add(d);
			}

			ntypes = doc.getElementsByTagName("answer");
			for (int i = 0; i < ntypes.getLength(); i++) {
				Element e = (Element) ntypes.item(i);
				
				String id= e.getAttribute("id");
				String did= e.getAttribute("did");
				String f= e.getTextContent();
				
				Answer d= new Answer(id, did, f);
				
				answers.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Verilen id ye göre dialogu verir
	 * @param id Dialog id si
	 * @return
	 */
	public Dialog getDialog(String id){
		for(Dialog d: dialogs){
			if(d.id.equals(id)){
				return d;
			}
		}
		return null;
	}

	/**
	 * Verilen dialog id sine verilecebilecek olan cevaplari verir
	 * @param id Dialog id si
	 * @return
	 */
	public List<Answer> getAnswers(String id){
		List<Answer> ret= new ArrayList<Answer>();
		for(Answer a: answers){
			if(a.did.equals(id)){
				ret.add(a);
			}
		}
		return ret;
	}
	
}
