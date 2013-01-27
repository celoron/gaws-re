package celoron.test;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import celoron.gui.GuiStyle;

public class MapState extends BasicGameState {
	int id;
	
	MapObjectMoveable ship= null;
	MapScene mscene;
	
	GuiStyle label;
	
	public MapState(int id){
		this.id=id;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		mscene= new MapScene(gc);
		
		label= new GuiStyle(new Image("data/btn_back.png"));
		label.setBorders(3, 3, 3, 3);
		label.setPaddings(10, 10, 8, 8);
		label.setFont("data/myriad.OTF", 20);
		
		Random rnd = new Random();
		for(int i=0; i<100; i++){
			mscene.add(new MapObject(new Image("data/rock.png"), new Vector2f(rnd.nextInt(2000)-1000, rnd.nextInt(2000)-1000)));
		}

		ship= new MapObjectMoveable(new Image("data/ship1.png"), new Vector2f(100,100), 2.5f);
		mscene.add(ship);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		mscene.renderAll();
		
		label.draw("Right mouse click to move ship", 500, 20);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		
		Input input= gc.getInput();
		if(input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)){
			Vector2f target= mscene.getWorldPosRelMouse();
			
			ship.setTarget(target);
			ship.lookAt(target);
		}

		mscene.setCamPos(ship.getPosition());
		mscene.updateAll();
	}

	@Override
	public int getID() {
		return id;
	}

}
