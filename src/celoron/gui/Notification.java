package celoron.gui;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import celoron.game.TheGame;

/**
 * Notificationlar� y�netir.
 * not:State ler taraf�ndan manual olarak �izilmesi gerekmektedir!
 * @author celoron
 *
 */
public class Notification {
	List<Not> nots;
	
	GuiStyle label;
	
	public Notification(){
		nots= new ArrayList<Not>();
		
		try {
			label= new GuiStyle(new Image("data/notBack.png"));
			label.setBorders(3, 3, 3, 3);
			label.setPaddings(5, 5, 5, 5);
			label.setMinWidth(400);
			label.setFont("data/myriad.OTF", 16);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		TheGame.script.put("notification", this);
	}
	
	public void render(){
		GuiLayout layout= new GuiLayoutVertical(10, 60);
		for(Not not: nots){
			layout.draw(label, not.text);
		}
	}
	
	public void update(float delta){
		List<Not> remove= new ArrayList<Not>();
		
		for(Not not: nots){
			not.timeLeft-=delta;
			if(not.timeLeft < 0){
				remove.add(not);
			}
		}
		nots.removeAll(remove);
	}
	
	/**
	 * Yeni not. ekleme
	 * @param text ��erik
	 * @param time Ya�am s�resi (saniye)
	 */
	public void add(String text, float time){
		nots.add(new Not(text, time));
	}
	
	class Not{
		public String text;
		public float timeLeft;
		
		public Not(String text, float time){
			this.text=text;
			this.timeLeft= time*10;
		}
	}
}
