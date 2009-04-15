package sheep.model;

import java.io.Serializable;
import java.util.Vector;

import sheep.model.entities.Avatar;
import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;

/**
 * 
 * @author Phil Freo
 */
public class Model implements Serializable {
	private static final long serialVersionUID = -3924966363628308694L;

	private boolean isPaused;
	private Time time = Time.getInstance();
	private GameStateType gameState;
	private Avatar avatar;
	private Entity mover;
	private GameMap gameMap;
	private Vector<GameStateObserver> gameStateObservers = new Vector<GameStateObserver>();
	
	public void pauseTime() {
		time.pause();
	}

	public void startTime() {
		time.start();
	}

	public void setState(GameStateType state) {
		GameStateChange msg = new GameStateChange(this.gameState, state);
		this.gameState = state;
		notifyGameStateChangeObservers(msg);
	}

	public void setMap(GameMap map) {
		this.gameMap = map;
	}

	public void registerObserver(GameStateObserver observer) {
		if (!gameStateObservers.contains(observer)) {
			gameStateObservers.add(observer);
		}
	}

	public void removeObserver(GameStateObserver observer) {
		gameStateObservers.remove(observer);
	}

	public void notifyGameStateChangeObservers(GameStateChange msg) {
		for (GameStateObserver observer : this.gameStateObservers) {
			observer.update(msg);
		}
	}

	public boolean isPaused() {
		return isPaused;
	}

	public Time getTime() {
		return time;
	}

	public GameStateType getGameState() {
		return gameState;
	}

	public Avatar getAvatar() {
		return avatar;
	}
	
	/**
	 * Sets a new Avatar.  Assumes that when setting an Avatar it's not in 
	 * a Vehicle
	 * @param avatar
	 */
	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
		this.mover = avatar;
	}

	public Entity getMover() {
		return mover;
	}

	public GameMap getGameMap() {
		return gameMap;
	}
}