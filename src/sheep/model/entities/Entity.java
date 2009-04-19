package sheep.model.entities;

import java.util.List;
import java.util.Vector;

import sheep.model.Model;
import sheep.model.Time;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;
import sheep.model.items.armor.Armor;
import sheep.model.items.weapons.Projectile;
import sheep.model.items.weapons.Weapon;
import sheep.util.math.Vector2D;

/**
 * An Entity is an object capable of moving itself on the map
 * @author Phil Freo
 */
public abstract class Entity extends Locatable implements Moveable, StatChangeObservable {

	private static final long serialVersionUID = -8117857590532885266L;

	private Direction facingDirection = Direction.N;
	private boolean isMoving = false;
	public boolean isMoving() {
		return isMoving;
	}

	public abstract boolean canSwim();
	
	public abstract boolean canClimb();
	
	public abstract boolean canWalk();
	
	public abstract boolean has(Takeable item);
	
	private long tickCounter = 0;

	public Entity(String id, Model model, Location loc) {
		super(id, model, loc);
		Time.getInstance().registerObserver(this);
	}

	public void setFacingDirection(Direction direction)
	{
		this.facingDirection = direction;
	}
	public void startMoving(Direction direction) {
		this.facingDirection = direction;
		this.isMoving = true;
		
		// Check for valid speed
		if (getSpeed() <= 0) {
			stopMoving();
			System.out.println("Entity's getSpeed returned 0");
			return;
		}

		// If we don't have to wait right now, move the entity
		if (tickCounter == 0) {
			move();
		}
	}

	public void stopMoving() {
		this.isMoving = false;
		//System.out.println("Entity stopped moving");
	}

	/**
	 * This is only to be called to teleport or push the entity... will move him to destination following
	 * normal blocking, touching rules
	 * @param dest
	 */
	public void move(Location dest) {
		

		// Get neighboring locatables
		List<Locatable> thingsOnTile = this.getGameMap().get(dest);
		
		// If no terrain or anything (edge of map), don't move
		if (thingsOnTile.size() == 0) {
			stopMoving();
			return;
		}

		// See if anything blocks
		for (Locatable neighbor : thingsOnTile) {
			if (neighbor.blocks(this)) {
				stopMoving();
				return;
			}
		}
		
		// Move is successful, do it
		this.setLocation(dest);
		//System.out.println("Entity moved to " + this.getLocation());

		// Touch everything on the location
		
		for (Locatable neighbor : thingsOnTile) {
			neighbor.touch(this);
		} 

	}
	/**
	 * Actually move the entity.  Call only when Entity hasn't moved too 
	 * recently according to its getSpeed() and the tick()s.
	 */
	private void move() {
		if(this.getLocation()==null)
			return;//dont move
		// Reset counter
		this.tickCounter = 30 - getSpeed();

		// Get ideal destination location
		Vector2D vector = facingDirection.getVector(this.getLocation());
		Location newLoc = this.getLocation().addVector(vector);

		// Get neighboring locatables
		List<Locatable> thingsOnTile = this.getGameMap().get(newLoc);
		
		// If no terrain or anything (edge of map), don't move
		if (thingsOnTile.size() == 0) {
			stopMoving();
			return;
		}

		// See if anything blocks
		for (Locatable neighbor : thingsOnTile) {
			if (neighbor.blocks(this)) {
				stopMoving();
				return;
			}
		}
		
		// Move is successful, do it
		this.setLocation(newLoc);
		//System.out.println("Entity moved to " + this.getLocation());

		// Touch everything on the location
		
		for (Locatable neighbor : thingsOnTile) {
			neighbor.touch(this);
		} 

	}

	//@Override
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
	@Override
	public void hitWith(Weapon w)
	{
		w.applyEffect(this);
	}

	public abstract void accept(LocatableVisitor v);

	public abstract boolean blocks(Entity entity);
	
	@Override
	public boolean blocks(Projectile p)
	{
		return true;
	}

	public abstract void affectStat(StatType stat, int changeAmt);

	public abstract int getStat(StatType stat);

	public abstract int getSpeed();
	
	public abstract void equip(Weapon w);
	
	public abstract void equip(Armor a);
	
	public abstract void weaponDamage(int amount);
}