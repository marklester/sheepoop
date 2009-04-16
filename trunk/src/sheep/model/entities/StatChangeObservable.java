package sheep.model.entities;


public interface StatChangeObservable {

	public void notifyStatChangeObservers(StatChange msg);

	public void registerStatChangeObserver(StatChangeObserver observer);

	public void removeStatChangeObserver(StatChangeObserver observer);


}
