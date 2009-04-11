package sheep.model;

import sheep.model.entities.Avatar;
import sheep.model.entities.Entity;

public class Model implements Observable<GameStateChange> {
	private boolean isPaused;
	public Time time;
	public GameStateType gameState;
	public Avatar avatar;
	public Entity mover;
	GameMap unnamed_GameMap_;
	Time unnamed_Time_;
	GameStateType unnamed_GameStateType_;

	public void pauseTime() {
		throw new UnsupportedOperationException();
	}

	public void startTime() {
		throw new UnsupportedOperationException();
	}

	public void setState(GameStateType state) {
		throw new UnsupportedOperationException();
	}

	public void setMap(GameMap map) {
		throw new UnsupportedOperationException();
	}

	public void registerObserver(Observer<GameStateChange> observer) {
		throw new UnsupportedOperationException();
	}

	public void removeObserver(Observer<GameStateChange> observer) {
		throw new UnsupportedOperationException();
	}

	public void notifyObservers() {
		throw new UnsupportedOperationException();
	}
}