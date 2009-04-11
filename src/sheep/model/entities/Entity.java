package sheep.model.entities;

import sheep.model.LocatableVisitor;
import sheep.model.StatType;

import com.sun.xml.internal.ws.handler.HandlerProcessor.Direction;

public abstract class Entity extends model.Locatable implements model.Moveable, model.Observable {
	public Direction facingDirection;
	model.Inventory unnamed_Inventory_;

	public Entity() {
		throw new UnsupportedOperationException();
	}

	public abstract void accept(LocatableVisitor v);

	public abstract boolean blocks(model.Entity entity);

	public void startMoving(Direction direction) {
		throw new UnsupportedOperationException();
	}

	public abstract void affectStat(StatType stat, int changeAmt);

	public void stopMoving() {
		throw new UnsupportedOperationException();
	}

	public model.Vector getVelocity() {
		throw new UnsupportedOperationException();
	}

	public abstract int getSpeed();

	public void tick() {
		throw new UnsupportedOperationException();
	}
}