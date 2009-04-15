package sheep.model.entities;

import java.util.List;

import sheep.model.Time;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;
import sheep.util.math.Vector2D;

/**
 * An Entity is an object capable of moving itself on the map
 * @author Phil Freo
 */
public abstract class Entity extends Locatable implements Moveable, StatChangeObservable {

	private static final long serialVersionUID = -8117857590532885266L;

	private Direction facingDirection = Direction.N;
	private boolean isMoving = false;
	private long tickCounter = 0;

	public Entity(String id, GameMap map, Location loc) {
		super(id, map, loc);
		Time.getInstance().registerObserver(this);
	}

	public void startMoving(Direction direction) {
		this.facingDirection = direction;
		this.isMoving = true;

		if (tickCounter == 0) {
			move();
		}
	}

	public void stopMoving() {
		this.isMoving = false;
		//System.out.println("Entity stopped moving");
	}

	/**
	 * Actually move the entity.  Call only when Entity hasn't moved too 
	 * recently according to its getSpeed() and the tick()s.
	 */
	private void move() {

		// Get ideal destination location
		Vector2D vector = facingDirection.getVector(this.getLocation());
		Location newLoc = this.getLocation().addVector(vector);

		// See if anything blocks
		List<Locatable> thingsOnTile = this.getGameMap().get(newLoc);
		for (Locatable neighbor : thingsOnTile) {
			if (neighbor.blocks(this)) {
				System.out.println("Entity was blocked by " + neighbor);
				stopMoving();
				return;
			}
		}
		
		// If no terrain or anything (edge of map), don't move
		if (thingsOnTile.size() == 0) {
			stopMoving();
			return;
		}

		// Move is successful, do it
		this.setLocation(newLoc);
		//System.out.println("Entity moved to " + this.getLocation());

		// Touch everything on the location
		for (Locatable neighbor : thingsOnTile) {
			neighbor.touch(this);
		}

		// Reset counter
		this.tickCounter = getSpeed();
	}

	@Override
	public void tick() {

		if (this.isMoving && tickCounter == 0) {
			move();
		}

		if (tickCounter > 0) {
			tickCounter--;
		}
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

}