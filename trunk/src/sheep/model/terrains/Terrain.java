package sheep.model.terrains;

import sheep.model.entities.Entity;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.LocatableVisitor;

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
		v.visit(this);
	}
}