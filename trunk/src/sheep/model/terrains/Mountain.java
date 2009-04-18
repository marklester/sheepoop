package sheep.model.terrains;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Location;
import sheep.model.items.weapons.Projectile;

public class Mountain extends Terrain {

	private static final long serialVersionUID = -1865946432520097267L;

	public Mountain(Model model, Location loc) {
		super("Mountain", model, loc);
	}

	@Override
	public boolean blocks(Entity entity) {
		return !entity.canClimb();
	}
	@Override
	public boolean blocks(Projectile p)
	{
		return true;
	}
}