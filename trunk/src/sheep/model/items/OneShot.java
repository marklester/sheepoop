package sheep.model.items;

import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public abstract class OneShot extends Item {

	private static final long serialVersionUID = -2451877763558545713L;
	
	public OneShot(String id, GameMap map, Location loc) {
		super(id, map, loc);
	}

	public abstract void touch(Entity entity);
	
}