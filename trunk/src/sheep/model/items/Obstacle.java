package sheep.model.items;

import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

/**
 * 
 * @author Phil Freo
 */
public class Obstacle extends Item {

	private static final long serialVersionUID = -3498178569028623819L;
	
	public Obstacle(String id, GameMap map, Location loc) {
		super(id, map, loc);
	}

	public boolean blocks(Entity entity) {
		return true;
	}
}