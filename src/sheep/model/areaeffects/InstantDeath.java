package sheep.model.areaeffects;

import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class InstantDeath extends AreaEffect {

	private static final long serialVersionUID = 7991051797350750281L;

	public InstantDeath(GameMap map, Location loc) {
		super("InstantDeath", map, loc);
	}
	
	public void applyEffect(Entity e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void tick() {
		
	}
}