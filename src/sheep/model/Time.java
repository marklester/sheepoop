package sheep.model;

import java.io.Serializable;
import java.util.Vector;

public class Time implements Serializable {

	private static final long serialVersionUID = 1061923003822374910L;

	private static Time instance = new Time();
	private Vector<TimeObserver> observers = new Vector<TimeObserver>();

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

	public void registerObserver(TimeObserver observer) {
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	public void removeObserver(TimeObserver observer) {
		observers.remove(observer);
	}

	public void notifyObservers() {
		for (TimeObserver observer : this.observers) {
			observer.tick();
		}
	}
}