package sheep.model;

public class GameStateChange implements ObservationType {
	GameStateType unnamed_GameStateType_;

	public GameStateChange(GameStateType oldState, GameStateType newState) {
		throw new UnsupportedOperationException();
	}

	public GameStateType getOldState() {
		throw new UnsupportedOperationException();
	}

	public GameStateType getNewState() {
		throw new UnsupportedOperationException();
	}
}