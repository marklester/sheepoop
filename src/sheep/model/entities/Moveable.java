package sheep.model.entities;

import sheep.model.TimeObserver;
import sheep.model.gamemap.Direction;

/**
 * 
 * @author Phil Freo
 */
public interface Moveable extends TimeObserver {

	public void startMoving(Direction direction);

	public void stopMoving();
}