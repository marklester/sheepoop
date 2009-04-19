package sheep.model.entities;

import java.io.Serializable;

/**
 * 
 * @author Phil Freo
 */
public enum InventoryChangeType implements Serializable {
	ITEM_ADDED("added to inventory"), ITEM_EQUIPPED("equipped"), ITEM_UNEQUIPPED("unequipped"), ITEM_USED("used"), ITEM_DROPPED("dropped");
	
	private String friendly;
	
	InventoryChangeType(String friendly) {
		this.friendly = friendly;
	}
	
	public String toString() {
		return this.friendly;
	}
}