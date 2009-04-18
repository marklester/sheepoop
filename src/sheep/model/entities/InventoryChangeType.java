package sheep.model.entities;

/**
 * 
 * @author Phil Freo
 */
public enum InventoryChangeType {
	ITEM_ADDED("added to inventory"), ITEM_EQUIPPED("equipped"), ITEM_UNEQUIPPED("unequipped"), ITEM_USED("used");
	
	private String friendly;
	
	InventoryChangeType(String friendly) {
		this.friendly = friendly;
	}
	
	public String toString() {
		return this.friendly;
	}
}