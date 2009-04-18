package sheep.model.terrains;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Location;

public class Grass extends Terrain {

	private static final long serialVersionUID = 983415190152824935L;

	public Grass(Model model, Location loc) {
		super("Grass", model, loc);
	}

	public boolean blocks(Entity entity) {
		return false;
	}
}