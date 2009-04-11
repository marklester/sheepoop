package sheep.model.terrains;

import sheep.model.entities.Entity;

public class Water extends Terrain {

	public Water(String id) {
		super(id);
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}
}