package sheep.model.items;

import sheep.model.Locatable;
import sheep.model.LocatableVisitor;
import sheep.model.entities.Entity;

public abstract class Item extends Locatable {

	public Item(String id) {
		super(id);
	}

	public void accept(LocatableVisitor v) {
		throw new UnsupportedOperationException();
	}

	/**
	 * default to nothing
	 */
	public void touch(Entity entity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * default to false
	 */
	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}
}