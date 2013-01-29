package celoron.game.map.query;

import celoron.game.map.MapObject;

public interface MapQueryFilter {
	boolean filter(MapObject mobj);
}
