package sheep.model.gamemap;

import java.io.Serializable;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.items.weapons.Projectile;
import sheep.model.items.weapons.Weapon;

/**
 * 
 * @author Phil Freo
 */
public abstract class Locatable implements Serializable {
	
	private static final long serialVersionUID = 2983990245744613911L;
	
	private Model model;
	private Location location;
	private String id;
	
	public Locatable(String id, Model model, Location loc) {
		this.id = id;
		this.model = model;
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
	
	
	public boolean blocks(Projectile p)
	{
		return false;
	}
	
	
	public void hitWith(Weapon w)
	{
		//Default is to do nothing
	}

	public String getID() {
		return this.id;
	}
	
	public Model getModel() {
		return this.model;
	}
	
	public GameMap getGameMap() {
		return this.model.getGameMap();
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(Location newLoc) {
		getGameMap().notifyOfMovement(this.location, newLoc, this);
		this.location = newLoc;
	}
}