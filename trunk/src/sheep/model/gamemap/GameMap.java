package sheep.model.gamemap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * 
 * @author Phil Freo
 */
public class GameMap implements Serializable {

	private static final long serialVersionUID = -6604540494991148223L;

	private HashMap<Location, Vector<Locatable>> map;

	public GameMap() {
		this.map = new HashMap<Location, Vector<Locatable>>();
	}

	public Vector<Locatable> get(Location loc) {
		Vector<Locatable> list = map.get(loc);
		if (list == null) {
			list = new Vector<Locatable>();
			map.put(loc, list);
		}
		return list;
	}

	public void add(Location loc, Locatable obj) {
		Vector<Locatable> locationList = get(loc);
		if (!locationList.contains(obj)) {
			locationList.add(obj);
		}
	}

	public boolean remove(Location loc, Locatable obj) {
		Vector<Locatable> list = map.get(loc);
		boolean result = list.remove(obj);
		return result;
	}

	public void notifyOfMovement(Location oldLoc, Location newLoc, Locatable obj) {
		// Remove Locatable from old Location
		Vector<Locatable> oldLocList = get(oldLoc);
		oldLocList.remove(obj);

		// Add it to new Location
		Vector<Locatable> newLocList = get(newLoc);
		if (!newLocList.contains(obj)) {
			newLocList.add(obj);
		}
	}

	public Map<Location, List<Locatable>> getMapSubset(int origin, int radius) {
		// TODO
		throw new UnsupportedOperationException();
	}
}