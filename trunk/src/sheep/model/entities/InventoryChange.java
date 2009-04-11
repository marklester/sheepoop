package sheep.model.entities;

import java.io.Serializable;

import sheep.model.ObservationType;
import sheep.model.items.Takeable;

/**
 * 
 * @author Phil Freo
 */

public class InventoryChange implements ObservationType, Serializable {
	private static final long serialVersionUID = 108425969770910129L;
	
	private final InventoryChangeType changeType;
	private final Takeable item;

	public InventoryChange(Takeable item, InventoryChangeType changeType) {
		this.changeType = changeType;
		this.item = item;
	}

	public InventoryChangeType getChangeType() {
		return changeType;
	}

	public Takeable getItem() {
		return item;
	}
}