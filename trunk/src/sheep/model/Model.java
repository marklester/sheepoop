package model;

public class Model implements model.Observable {
	private boolean isPaused;
	public model.Time time;
	public model.GameStateType gameState;
	public model.Avatar avatar;
	public model.Entity mover;
	model.GameMap unnamed_GameMap_;
	model.Time unnamed_Time_;
	model.GameStateType unnamed_GameStateType_;

	public void pauseTime() {
		throw new UnsupportedOperationException();
	}

	public void startTime() {
		throw new UnsupportedOperationException();
	}

	public void setState(GameStateType state) {
		throw new UnsupportedOperationException();
	}

	public void setMap(model.GameMap map) {
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