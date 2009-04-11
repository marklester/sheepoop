package sheep.model.terrains;

import sheep.model.entities.Entity;

public class Grass extends Terrain {

	private static final long serialVersionUID = 983415190152824935L;

	public Grass(String id) {
		super(id);
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}
}