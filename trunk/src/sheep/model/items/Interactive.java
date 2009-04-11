package sheep.model.items;

import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public abstract class Interactive extends Item {

	private static final long serialVersionUID = 4777965387803747234L;
	
	public Interactive(String id, GameMap map, Location loc) {
		super(id, map, loc);
	}

	public void touch(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}
	
}