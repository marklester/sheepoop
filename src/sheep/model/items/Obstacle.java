package sheep.model.items;

import sheep.model.entities.Entity;

public class Obstacle extends Item {

	public Obstacle(String id) {
		super(id);
	}

	public boolean blocks(Entity entity) {
		return true;
	}
}