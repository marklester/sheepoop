package sheep.model.terrains;

import sheep.model.entities.Entity;

public class Water extends Terrain {

	private static final long serialVersionUID = 2704206030432343190L;

	public Water(String id) {
		super(id);
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}
}