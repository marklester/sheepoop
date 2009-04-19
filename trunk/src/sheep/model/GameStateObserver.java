package sheep.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Phil Freo
 */
public interface GameStateObserver {
	public void update(GameStateChange msg);
	
}
