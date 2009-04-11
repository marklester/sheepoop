package sheep.model.areaeffects;

import sheep.model.TimeChange;
import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class TakeDamage extends AreaEffect {

	private static final long serialVersionUID = -1922478825658683800L;

	public TakeDamage(GameMap map, Location loc) {
		super("TakeDamage", map, loc);
	}

	public void applyEffect(Entity e) {
		throw new UnsupportedOperationException();
	}

	public void update(TimeChange msg) {
		
	}
}