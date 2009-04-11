package sheep.model.terrains;

import sheep.model.entities.Entity;

public class Mountain extends Terrain {

	private static final long serialVersionUID = -1865946432520097267L;

	public Mountain(String id) {
		super(id);
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}
}