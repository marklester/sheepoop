package model;

public abstract class Takeable extends model.Item {
	model.Inventory unnamed_Inventory_;

	/**
	 * entity.addtoInventory(this)
	 */
	public void touch(model.Entity entity) {
		throw new UnsupportedOperationException();
	}

	public abstract void use(model.Entity entity);

	public boolean blocks(model.Entity entity) {
		throw new UnsupportedOperationException();
	}

	public String getID() {
		throw new UnsupportedOperationException();
	}
}