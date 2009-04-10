package model;

public abstract class Terrain extends model.Locatable {

	public void touch(model.Entity entity) {
		throw new UnsupportedOperationException();
	}

	public abstract boolean blocks(model.Entity entity);

	public String getID() {
		throw new UnsupportedOperationException();
	}

	public void accept(LocatableVisitor v) {
		throw new UnsupportedOperationException();
	}
}