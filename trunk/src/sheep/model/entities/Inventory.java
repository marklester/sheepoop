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
	
	public Inventory() {
		items = new Vector<Takeable>();
	}
	
	public void add(Takeable item) {
		items.add(item);
	}

	public boolean remove(Takeable item) {
		return items.remove(item);
	}

	public Iterable<Takeable> get() {
		return items;
	}
	
	public int getSize() {
		if (items != null) 
			return items.size();
		else
			return 0;
	}
	public boolean has(Takeable t)
	{
		return(items.contains(t));
	}
}