package sheep.model;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 
 * @author Phil Freo
 */
public class Time implements Serializable {

	private static final long serialVersionUID = 1061923003822374910L;

	private static final int TICKS_PER_SECOND = 30;
	private static Time instance = new Time();
	private ConcurrentLinkedQueue<TimeObserver> observers;
	transient private ConcurrentLinkedQueue<TimeObserver> transientObservers;
	transient private Timer timer = new Timer();
	private boolean isPaused;

	private Time() {
		this.isPaused = true;
		this.transientObservers = new ConcurrentLinkedQueue<TimeObserver>();
		this.observers = new ConcurrentLinkedQueue<TimeObserver>();;
	}

	public static Time getInstance() {
		return instance;
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void pause() {

		if (timer != null) {
			timer.cancel();
			// once you call cancel on a timer, you can no longer schedule tasks
			// on it.
			timer = null;
		}

		this.isPaused = true;
	}

	public void start() {

		// because timers can't be serialized, it might be null, despite how
		// impossible it seems
		if (timer == null)
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
		
		if (!(observer instanceof Serializable)) {
			if (!transientObservers.contains(observer)) {
				transientObservers.add(observer);
			}
			return;
		}
		
		if (!observers.contains(observer)) {
			observers.add(observer);
		}

	}

	public void removeObserver(TimeObserver observer) {
		observers.remove(observer);
		transientObservers.remove(observer);
	}

	public void notifyObservers() {

		for (TimeObserver observer : this.observers) {
			if(observer!=null)
			{
				observer.tick();
			}
			else
			{
				observers.remove(observer);
			}
		}
		
		for (TimeObserver observer : this.transientObservers) {
			if(observer!=null)
			{
				observer.tick();
			}
			else
			{
				observers.remove(observer);
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