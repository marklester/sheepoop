package sheep.model.entities;

import sheep.model.Direction;
import sheep.model.Locatable;
import sheep.model.LocatableVisitor;
import sheep.model.Observable;
import sheep.model.Vector2D;

public abstract class Entity extends Locatable implements Moveable, Observable<StatChange> {

	public Direction facingDirection;
	private Inventory inventory;

	public Entity(String id) {
		super(id);
	}

	public abstract void accept(LocatableVisitor v);

	public abstract boolean blocks(Entity entity);

	public void startMoving(Direction direction) {
		throw new UnsupportedOperationException();
	}

	public abstract void affectStat(StatType stat, int changeAmt);

	public void stopMoving() {
		throw new UnsupportedOperationException();
	}

	public Vector2D getVelocity() {
		throw new UnsupportedOperationException();
	}

	public abstract int getSpeed();

	public void tick() {
		throw new UnsupportedOperationException();
	}
}