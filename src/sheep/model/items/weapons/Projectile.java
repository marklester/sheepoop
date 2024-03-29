package sheep.model.items.weapons;

import java.util.List;

import sheep.model.Model;
import sheep.model.Time;
import sheep.model.entities.Moveable;
import sheep.model.gamemap.Direction;
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
	private int duration=-1;
	private static final long serialVersionUID = 1L;

	public Projectile(String id, Model model, Location loc, Weapon w, Direction facing, int speed,int duration)
	{
		super (id, model, loc);
		this.facingDirection = facing;
		startMoving(facing);
		this.speed = speed;
		myWeapon = w;
		tickCounter = speed;
		this.duration = duration;
		Time.getInstance().registerObserver(this);
	}
	public Projectile(String id, Model model, Location loc, Weapon w, Direction facing, int speed){
		super (id, model, loc);
		this.facingDirection = facing;
		startMoving(facing);
		this.speed = speed;
		myWeapon = w;
		tickCounter = speed;
		this.duration = -1;
		Time.getInstance().registerObserver(this);
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
		//If the duration of the Project has expired kill it
		if(duration==0){
			stopMoving();
			return;
		}
		// See if anything blocks
		List<Locatable> thingsOnTile = this.getGameMap().get(newLoc);
		if(!thingsOnTile.isEmpty())
		{
			boolean hit = false;
			for (Locatable neighbor : thingsOnTile) {
				if (neighbor.blocks(this)) {
					hit=true;
					neighbor.hitWith(myWeapon);
				}
			}
			if(hit == true){
				stopMoving();
				return;
			}

			// If no terrain or anything (edge of map), don't move
			if (thingsOnTile.size() == 0) {
				stopMoving();
				return;
			}
			// Move is successful, do it
			this.setLocation(newLoc);
			duration--;
			//System.out.println("Entity moved to " + this.getLocation());

			// Reset counter
			this.tickCounter = speed;
		}
		else
		{
			stopMoving();
		}
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
