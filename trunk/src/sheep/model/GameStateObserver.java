package sheep.model;


/**
 * 
 * @author Phil Freo
 */
public interface GameStateObserver {
	public void update(GameStateChange msg);

}
