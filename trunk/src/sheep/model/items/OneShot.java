package sheep.model.items;

import sheep.model.entities.Entity;

public abstract class OneShot extends Item {

	private static final long serialVersionUID = -2451877763558545713L;

	public OneShot(String id) {
		super(id);
	}

	public abstract void touch(Entity entity);
	
}