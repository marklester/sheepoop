package sheep.model.items;

import sheep.model.entities.Entity;

public abstract class OneShot extends Item {

	public OneShot(String id) {
		super(id);
	}

	public abstract void touch(Entity entity);
	
}