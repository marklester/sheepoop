package sheep.model.items;

import sheep.model.entities.Entity;

public class Interactive extends Item {

	public Interactive(String id) {
		super(id);
	}

	public void touch(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public String getID() {
		throw new UnsupportedOperationException();
	}
}