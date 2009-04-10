package model;

public class Time implements model.Observable {
	public static model.Time instance;
	model.Model unnamed_Model_;

	private Time() {
		throw new UnsupportedOperationException();
	}

	public static model.Time getInstance() {
		throw new UnsupportedOperationException();
	}

	public void pause() {
		throw new UnsupportedOperationException();
	}

	public void start() {
		throw new UnsupportedOperationException();
	}

	public void registerObserver(model.Observer<T> observer) {
		throw new UnsupportedOperationException();
	}

	public void removeObserver(model.Observer<T> observer) {
		throw new UnsupportedOperationException();
	}

	public void notifyObservers() {
		throw new UnsupportedOperationException();
	}
}