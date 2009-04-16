package sheep.model.entities;

public interface InventoryChangeObservable {

	public void notifyInventoryChangeObservers(InventoryChange msg);

	public void registerInventoryChangeObserver(InventoryChangeObserver observer);

	public void removeInventoryChangeObserver(InventoryChangeObserver observer);

}
