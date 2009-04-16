package sheep.model.items.weapons;

import java.util.Vector;

import sheep.model.Time;
import sheep.model.entities.Moveable;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;
import sheep.util.math.Vector2D;

public class Projectile extends Locatable implements Moveable
{
	private Direction facingDirection;
	private int speed;
	private Weapon myWeapon;
	int tickCounter;
	
	private static final long serialVersionUID = 1L;

	public Projectile(String id, GameMap map, Location loc, Weapon w, Direction facing, int speed)
	{
		super (id, map, loc);
		this.facingDirection = facing;
		startMoving(facing);
		this.speed = speed;
		myWeapon = w;
		Time.getInstance().registerObserver(this);
		tickCounter = speed;
	}
	public Direction getFacingDirection() {
		return facingDirection;
	}

	@Override
	public void accept(LocatableVisitor v)
	{
		v.visit(this);

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
		Vector<Locatable> thingsOnTile = this.getGameMap().get(newLoc);
		for (Locatable neighbor : thingsOnTile) {
			if (neighbor.blocks(this)) {
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

		// Hit everything on the location
		for (Locatable neighbor : thingsOnTile) {
			neighbor.hitWith(myWeapon);
		}

		// Reset counter
		this.tickCounter = speed;
	}

	//@Override
	public void tick() {

		if (tickCounter == 0) {
			move();
		}

		if (tickCounter > 0) {
			tickCounter--;
		}
	}
	@Override
	public void startMoving(Direction direction)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void stopMoving()
	{
		getGameMap().remove(getLocation(), this);
		Time.getInstance().removeObserver(this);
	}
}
