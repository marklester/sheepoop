package sheep.model.terrains;

import sheep.model.entities.Entity;

public class Grass extends Terrain {

	public Grass(String id) {
		super(id);
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}
}