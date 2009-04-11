package sheep.model.terrains;

import sheep.model.Locatable;
import sheep.model.LocatableVisitor;
import sheep.model.entities.Entity;

public abstract class Terrain extends Locatable {

	private static final long serialVersionUID = 7489043479583637533L;

	public Terrain(String id) {
		super(id);
	}

	public void touch(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public abstract boolean blocks(Entity entity);

	public String getID() {
		throw new UnsupportedOperationException();
	}

	public void accept(LocatableVisitor v) {
		throw new UnsupportedOperationException();
	}
}