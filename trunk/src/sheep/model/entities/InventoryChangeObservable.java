package sheep.model.entities;



public interface InventoryChangeObservable {

	public void notifyInventoryChangeObservers(InventoryChange msg);

	public void registerObserver(InventoryChangeObserver observer);

	public void removeObserver(InventoryChangeObserver observer);

}
