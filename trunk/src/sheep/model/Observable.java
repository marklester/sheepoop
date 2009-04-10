package model;

public interface Observable<T extends model.ObservationType> {

	public void registerObserver(model.Observer<T> observer);

	public void removeObserver(model.Observer<T> observer);

	public void notifyObservers();
}