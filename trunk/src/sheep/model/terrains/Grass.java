package sheep.model.terrains;

import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class Grass extends Terrain {

	private static final long serialVersionUID = 983415190152824935L;

	public Grass(GameMap map, Location loc) {
		super("Grass", map, loc);
	}

	public boolean blocks(Entity entity) {
		return false;
	}
}