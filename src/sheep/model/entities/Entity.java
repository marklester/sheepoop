package sheep.model.entities;

import sheep.model.Observable;
import sheep.model.Observer;
import sheep.model.TimeChange;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;
import util.math.Vector2D;

public abstract class Entity extends Locatable implements Moveable, Observable<StatChange> {

	private static final long serialVersionUID = -8117857590532885266L;
	public Direction facingDirection;
	private Inventory inventory;
	
	public Entity(String id, GameMap map, Location loc) {
		super(id, map, loc);
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

	@Override
	public void update(TimeChange msg) {
	}

}