package sheep.model.entities;

import sheep.model.ObservationType;
import sheep.model.items.Takeable;

public class InventoryChange implements ObservationType {
	InventoryChangeType changeType;

	public InventoryChange(Takeable item, InventoryChangeType changeType) {
		throw new UnsupportedOperationException();
	}

	public InventoryChangeType getChangeType() {
		throw new UnsupportedOperationException();
	}

	public Takeable getItem() {
		throw new UnsupportedOperationException();
	}
}