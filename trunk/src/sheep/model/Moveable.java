package model;

public interface Moveable implements model.Observer {

	public void startMoving(Direction direction);

	public void stopMoving();
}