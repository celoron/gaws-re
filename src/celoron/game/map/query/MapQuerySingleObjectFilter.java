package celoron.game.map.query;

import celoron.game.map.MapObject;

public class MapQuerySingleObjectFilter implements MapQueryFilter {
	MapObject mobj;
	
	public MapQuerySingleObjectFilter(MapObject mobj){
		this.mobj= mobj;
	}
	
	@Override
	public boolean filter(MapObject mobj) {
		if(mobj==this.mobj)
			return false;
		
		return true;
	}

}
