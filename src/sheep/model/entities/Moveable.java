package sheep.model.entities;

import sheep.model.Observer;
import sheep.model.TimeChange;
import sheep.model.gamemap.Direction;

public interface Moveable extends Observer<TimeChange> {

	public void startMoving(Direction direction);

	public void stopMoving();
}