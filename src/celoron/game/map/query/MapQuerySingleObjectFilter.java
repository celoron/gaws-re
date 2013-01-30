package celoron.game.map.query;

import celoron.game.map.MapObject;

/**
 * Verilen harita objesini listeden eler
 * @author celoron
 *
 */
public class MapQuerySingleObjectFilter implements MapQueryFilter {
	MapObject mobj;
	
	/**
	 * Verilen harita objesini listeden eler
	 * @param mobj elenecek harita objesi
	 */
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
