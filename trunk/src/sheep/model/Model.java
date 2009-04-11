package sheep.model;

import java.io.Serializable;

import sheep.model.entities.Avatar;
import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;

public class Model implements Observable<GameStateChange>, Serializable {
	private static final long serialVersionUID = -3924966363628308694L;
	
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