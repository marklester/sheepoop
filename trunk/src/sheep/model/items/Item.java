package sheep.model.items;

import sheep.model.Locatable;
import sheep.model.LocatableVisitor;
import sheep.model.entities.Entity;

/**
 * 
 * @author Phil Freo
 */
public abstract class Item extends Locatable {

	private static final long serialVersionUID = 3073304023154267109L;

	public Item(String id) {
		super(id);
	}

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}

	/**
	 * default to nothing
	 */
	public void touch(Entity entity) {
		
	}

	/**
	 * default to false
	 */
	public boolean blocks(Entity entity) {
		return false;
	}
}