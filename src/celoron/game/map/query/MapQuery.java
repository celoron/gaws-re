package celoron.game.map.query;

import java.util.ArrayList;
import java.util.List;

import celoron.game.map.MapObject;
import celoron.game.map.MapScene;

public class MapQuery {
	List<MapObject> mobjects;
	
	public MapQuery(MapScene mscene){
		mobjects= mscene.getAll();
	}
	
	public MapQuery filter(MapQueryFilter filter){
		List<MapObject> newList= new ArrayList<MapObject>();
		for(MapObject mobj: mobjects){
			if(filter.filter(mobj)){
				newList.add(mobj);
			}
		}
		
		mobjects= newList;
		return this;
	}
	
	public List<MapObject> list(){
		return mobjects;
	}
}
