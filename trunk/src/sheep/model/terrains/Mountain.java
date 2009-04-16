package sheep.model.terrains;

import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.items.weapons.Projectile;

public class Mountain extends Terrain {

	private static final long serialVersionUID = -1865946432520097267L;

	public Mountain(GameMap map, Location loc) {
		super("Mountain", map, loc);
	}

	@Override
	public boolean blocks(Entity entity) {
		return true;
	}
	@Override
	public boolean blocks(Projectile p)
	{
		return true;
	}
}