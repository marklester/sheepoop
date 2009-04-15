package sheep.model.entities;

import java.util.Vector;

import sheep.model.gamemap.Direction;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;
import sheep.util.math.Vector2D;

public abstract class Entity extends Locatable implements Moveable, StatChangeObservable {

	private static final long serialVersionUID = -8117857590532885266L;
	
	private Direction facingDirection = Direction.N;
	private Inventory inv;

	public Entity(String id, GameMap map, Location loc) {
		super(id, map, loc);
	}

	public void startMoving(Direction direction) {	
		System.out.println("Entity is moving " + direction);
	}

	public void stopMoving() {
		System.out.println("Entity stopped moving");
	}

	public Vector2D getVelocity() {
		throw new UnsupportedOperationException();
	}
	
	public Direction getFacingDirection() {
		return facingDirection;
	}

	public abstract void accept(LocatableVisitor v);

	public abstract boolean blocks(Entity entity);

	public abstract void affectStat(StatType stat, int changeAmt);
	
	public abstract int getStat(StatType stat);

	public abstract int getSpeed();

	@Override
	public void tick() {
		
	}

}