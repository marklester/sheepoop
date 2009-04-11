package sheep.model;

public interface Observable<T extends ObservationType> {

	public void registerObserver(Observer<T> observer);

	public void removeObserver(Observer<T> observer);

	public void notifyObservers();
}