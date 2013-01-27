package celoron.test;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MapState extends BasicGameState {
	int id;
	
	MapObjectMoveable ship= null;
	MapScene mscene= new MapScene();
	
	public MapState(int id){
		this.id=id;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {

		ship= new MapObjectMoveable(new Image("data/ship1.png"), new Vector2f(100,100), 2.5f);
		mscene.add(ship);
		
		mscene.add(new MapObject(new Image("data/rock.png"), new Vector2f(200,100)));
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		mscene.renderAll();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		
		Input input= gc.getInput();
		if(input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)){
			Vector2f target= new Vector2f(input.getMouseX(), input.getMouseY());
			
			ship.setTarget(target);
			ship.lookAt(target);
		}

		mscene.updateAll();
	}

	@Override
	public int getID() {
		return id;
	}

}
