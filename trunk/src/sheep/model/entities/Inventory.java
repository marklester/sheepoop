package sheep.model.entities;

import java.io.Serializable;
import java.util.Vector;

import sheep.model.items.Takeable;

/**
 * 
 * @author Phil Freo
 */
public class Inventory implements Serializable {
	private static final long serialVersionUID = -2623162576357507941L;
	
	private Vector<Takeable> items;

	public void add(Takeable item) {
		items.add(item);
	}

	public boolean remove(Takeable item) {
		return items.remove(item);
	}

	public Iterable<Takeable> get() {
		return items;
	}
}