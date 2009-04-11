package sheep.model;

import java.io.Serializable;

public class Time implements Observable<TimeChange>, Serializable {
	private static final long serialVersionUID = 1061923003822374910L;
	
	public static Time instance = new Time();

	private Time() {
		
	}

	public static Time getInstance() {
		return instance;
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