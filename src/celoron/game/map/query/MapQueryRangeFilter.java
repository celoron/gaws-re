package celoron.game.map.query;

import org.newdawn.slick.geom.Vector2f;

import celoron.game.map.MapObject;

/**
 * Verilen poziyona göre yine verilen menzilin dýþýndaki objeleri eler
 * @author celoron
 *
 */
public class MapQueryRangeFilter implements MapQueryFilter {
	Vector2f origin;
	float rangeSq; //range squared, for performance purpose
	
	/**
	 * 
	 * @param origin Merkez noktasý
	 * @param range Menzil
	 */
	public MapQueryRangeFilter(Vector2f origin, float range){
		this.origin=origin;
		rangeSq= range*range;
	}
	
	@Override
	public boolean filter(MapObject mobj) {
		if(mobj.getPosition().sub(origin).lengthSquared() < rangeSq){
			return true;
		}
		return false;
	}
}
