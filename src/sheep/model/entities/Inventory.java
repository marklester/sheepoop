package sheep.model.entities;

import java.io.Serializable;
import java.util.List;

import sheep.model.items.Takeable;

public class Inventory implements Serializable {
	private static final long serialVersionUID = -2623162576357507941L;
	private List<Takeable> items;
	private Entity entity;

	public void add(Takeable item) {
		throw new UnsupportedOperationException();
	}

	public boolean remove(Takeable item) {
		throw new UnsupportedOperationException();
	}

	public Iterable<Takeable> get() {
		throw new UnsupportedOperationException();
	}
}