package sheep.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * @author Phil Freo
 */
public class Time implements Serializable {

	private static final long serialVersionUID = 1061923003822374910L;

	private static final int TICKS_PER_SECOND = 30;
	private static Time instance = new Time();
	private List<TimeObserver> observers;
	transient private Timer timer = new Timer();
	private boolean isPaused;

	private Time() {
		this.isPaused = true;

		List<TimeObserver> observers = new ArrayList<TimeObserver>();
		this.observers = Collections.synchronizedList(observers);
	}

	public static Time getInstance() {
		return instance;
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void pause() {
		
		if( timer != null)
			timer.cancel();
		
		this.isPaused = true;
	}

	public void start() {
		
		//because timers can't be serialized, it might be null, despite how impossible it seems
		if( timer == null)
			timer = new Timer();
		
		// Make sure Timer isn't already going
		if (!isPaused) {
			return;
		}

		// Create timer
		float millisBetweenTicks = 1f / (float) TICKS_PER_SECOND * 1000f;
		timer.schedule(new TickTimeTask(), 0, (long) millisBetweenTicks);

		this.isPaused = false;
	}

	public void registerObserver(TimeObserver observer) {
		synchronized (observers) {
			if (!observers.contains(observer)) {
				observers.add(observer);
			}
		}
	}

	public void removeObserver(TimeObserver observer) {
		observers.remove(observer);
	}

	public void notifyObservers() {
		synchronized (observers) {
			for (TimeObserver observer : this.observers) {
				observer.tick();
			}
		}
	}

	private class TickTimeTask extends TimerTask {

		@Override
		public void run() {
			notifyObservers();
		}

	}
}