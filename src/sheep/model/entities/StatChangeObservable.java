package sheep.model.entities;


public interface StatChangeObservable {

	public void notifyStatChangeObservers(StatChange msg);

	public void registerObserver(StatChangeObserver observer);

	public void removeObserver(StatChangeObserver observer);


}
