package sheep.model.terrains;

import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class Water extends Terrain {

	private static final long serialVersionUID = 2704206030432343190L;

	public Water(GameMap map, Location loc) {
		super("Water", map, loc);
	}

	public boolean blocks(Entity entity) {
		return true;
	}
}