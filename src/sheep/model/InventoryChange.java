package model;

public class InventoryChange implements model.ObservationType {
	model.InventoryChangeType unnamed_InventoryChangeType_;

	public InventoryChange(model.Takeable item, model.InventoryChangeType changeType) {
		throw new UnsupportedOperationException();
	}

	public model.InventoryChangeType getChangeType() {
		throw new UnsupportedOperationException();
	}

	public model.Takeable getItem() {
		throw new UnsupportedOperationException();
	}
}