package sheep.model.items;

import sheep.model.entities.Entity;

public abstract class Takeable extends Item {

	public Takeable(String id) {
		super(id);
	}

	/**
	 * entity.addtoInventory(this)
	 */
	public void touch(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public abstract void use(Entity entity);

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}

}