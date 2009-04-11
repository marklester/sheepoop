package sheep.model.entities;

import sheep.model.Direction;
import sheep.model.Observer;
import sheep.model.TimeChange;

public interface Moveable extends Observer<TimeChange> {

	public void startMoving(Direction direction);

	public void stopMoving();
}