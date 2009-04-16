package sheep.model.items.weapons;

import sheep.model.entities.Moveable;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.LocatableVisitor;
import sheep.model.gamemap.Location;

public class Projectile extends Locatable implements Moveable
{
	private static final long serialVersionUID = 1L;

	public Projectile(String id, GameMap map, Location loc)
	{
		super (id, map, loc);
		
	}

	@Override
	public void accept(LocatableVisitor v)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startMoving(Direction direction)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopMoving()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick()
	{
		// TODO Auto-generated method stub
		
	}
}
