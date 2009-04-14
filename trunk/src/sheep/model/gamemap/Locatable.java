package sheep.model.gamemap;

import java.io.Serializable;

import sheep.model.entities.Entity;

/**
 * 
 * @author Phil Freo
 */
public abstract class Locatable implements Serializable {
	
	private static final long serialVersionUID = 2983990245744613911L;
	
	private GameMap map;
	private Location location;
	private String id;

	public Locatable(String id, GameMap map, Location loc) {
		this.id = id;
		this.map = map;
		this.location = loc;
	}

	public abstract void accept(LocatableVisitor v);

	/**
	 * Called when an Entity comes in contact with this object.  By default,
	 * do nothing.
	 * @param entity
	 */
	public void touch(Entity entity) {
	}

	/**
	 * Should this object block a given Entity from entering its location? By 
	 * default, return false.
	 * @param entity
	 * @return
	 */
	public boolean blocks(Entity entity) {
		return false;
	}

	public String getID() {
		return this.id;
	}
	
	public GameMap getGameMap() {
		return this.map;
	}
	
	public Location getLocation() {
		return this.location;
	}
}