package sheep.model.items;

import sheep.model.entities.Entity;

public class Obstacle extends Item {

	private static final long serialVersionUID = -3498178569028623819L;

	public Obstacle(String id) {
		super(id);
	}

	public boolean blocks(Entity entity) {
		return true;
	}
}