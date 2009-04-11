package sheep.model.terrains;

import sheep.model.entities.Entity;

public class Mountain extends Terrain {

	public Mountain(String id) {
		super(id);
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}
}