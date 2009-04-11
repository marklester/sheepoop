package sheep.model.entities;

import java.util.List;

import sheep.model.items.Takeable;

public class Inventory {
	private List<Takeable> items;
	Entity entity;
	Takeable takeable;

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