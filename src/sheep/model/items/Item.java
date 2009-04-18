package sheep.model.items;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;

/**
 * 
 * @author Phil Freo
 */
public abstract class Item extends Locatable {

	private static final long serialVersionUID = 3073304023154267109L;
	
	public Item(String id, Model model, Location loc) {
		super(id, model, loc);
	}

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}

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
}