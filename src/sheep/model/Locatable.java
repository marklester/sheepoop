package sheep.model;

import sheep.model.entities.Entity;

public abstract class Locatable {
	
	public Location loc;
	public GameMap map;
	private GameMap gameMap;
	private Location location;
	private String id;

	public Locatable(String id) {
		this.id = id;
	}

	public abstract void accept(LocatableVisitor v);

	public void touch(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public String getID() {
		return this.id;
	}
}