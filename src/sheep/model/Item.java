package model;

public abstract class Item extends model.Locatable {

	public void accept(LocatableVisitor v) {
		throw new UnsupportedOperationException();
	}

	/**
	 * default to nothing
	 */
	public void touch(model.Entity entity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * default to false
	 */
	public boolean blocks(model.Entity entity) {
		throw new UnsupportedOperationException();
	}
}