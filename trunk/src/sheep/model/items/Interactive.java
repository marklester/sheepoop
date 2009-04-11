package sheep.model.items;

import sheep.model.entities.Entity;

public abstract class Interactive extends Item {

	private static final long serialVersionUID = 4777965387803747234L;

	public Interactive(String id) {
		super(id);
	}

	public void touch(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}
	
}