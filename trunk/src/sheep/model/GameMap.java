package sheep.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class GameMap implements Serializable {
	
	private static final long serialVersionUID = -6604540494991148223L;
	
	private Map<Location, List<Locatable>> map;

	public List<Locatable> get(Location loc) {
		throw new UnsupportedOperationException();
	}

	public void add(Location loc, Locatable obj) {
		throw new UnsupportedOperationException();
	}

	public void remove(Location loc, Locatable obj) {
		throw new UnsupportedOperationException();
	}

	public void notifyOfMovement(Location oldLoc, Location newLoc, Location obj) {
		throw new UnsupportedOperationException();
	}

	public Map<Location, List<Locatable>> getMapSubset(int origin, int radius) {
		throw new UnsupportedOperationException();
	}
}