package sheep.model.terrains;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Location;

public class Water extends Terrain {

	private static final long serialVersionUID = 2704206030432343190L;

	public Water(Model model, Location loc) {
		super("Water", model, loc);
	}

	public boolean blocks(Entity entity) {
		
		// Boats can pass
		if (entity.getID().equals("Boat")) {
			return false;
		}
		
		// Other avatars can't
		return true;
	}
}