package sheep.model.areaeffects;

import sheep.model.TimeChange;
import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class HealDamage extends AreaEffect {

	private static final long serialVersionUID = -4014549164957535326L;

	public HealDamage(GameMap map, Location loc) {
		super("HealDamage", map, loc);
	}

	public void applyEffect(Entity e) {
		throw new UnsupportedOperationException();
	}

	public void update(TimeChange msg) {
		
	}
}