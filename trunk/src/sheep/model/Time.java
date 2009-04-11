package sheep.model;

public class Time implements Observable<TimeChange> {
	public static Time instance;
	Model unnamed_Model_;

	private Time() {
		throw new UnsupportedOperationException();
	}

	public static Time getInstance() {
		throw new UnsupportedOperationException();
	}

	public void pause() {
		throw new UnsupportedOperationException();
	}

	public void start() {
		throw new UnsupportedOperationException();
	}

	public void registerObserver(Observer<TimeChange> observer) {
		throw new UnsupportedOperationException();
	}

	public void removeObserver(Observer<TimeChange> observer) {
		throw new UnsupportedOperationException();
	}

	public void notifyObservers() {
		throw new UnsupportedOperationException();
	}
}