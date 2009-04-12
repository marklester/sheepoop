package sheep.model;

import java.io.Serializable;

/**
 * 
 * @author Phil Freo
 */
public class GameStateChange implements Serializable {
	private static final long serialVersionUID = 6410235624239393294L;
	private final GameStateType oldState;
	private final GameStateType newState;

	public GameStateChange(GameStateType oldState, GameStateType newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	public GameStateType getOldState() {
		return oldState;
	}

	public GameStateType getNewState() {
		return newState;
	}
}