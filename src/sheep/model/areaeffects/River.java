package sheep.model.areaeffects;

import sheep.model.TimeChange;
import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class River extends AreaEffect {

	private static final long serialVersionUID = -2338346084817804369L;

	public River(GameMap map, Location loc) {
		super("River", map, loc);
	}

	public void applyEffect(Entity e) {
		throw new UnsupportedOperationException();
	}

	public void update(TimeChange msg) {
		
	}
}