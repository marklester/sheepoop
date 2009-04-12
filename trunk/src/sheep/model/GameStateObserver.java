package sheep.model;

public interface GameStateObserver {
	public void update(GameStateChange msg);
}
