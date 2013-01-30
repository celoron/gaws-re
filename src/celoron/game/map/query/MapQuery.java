package celoron.game.map.query;

import java.util.ArrayList;
import java.util.List;

import celoron.game.map.MapObject;
import celoron.game.map.MapScene;

/**
 * Verilen filtrelere göre harita objerini bulan arama sýnýfý
 * @author celoron
 *
 */
public class MapQuery {
	List<MapObject> mobjects;
	
	/**
	 * Harita sahnesi verilerek construct edilir.
	 * @param mscene
	 */
	public MapQuery(MapScene mscene){
		mobjects= mscene.getAll();
	}
	
	/**
	 * O anki listeden harita objelerini filtrelemek için kullanýlýr
	 * @param filter
	 * @return
	 */
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
	
	/**
	 * Filtrelemeden sonra kalan listeyi verir
	 * @return
	 */
	public List<MapObject> list(){
		return mobjects;
	}
}
