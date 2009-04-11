package sheep.model.areaeffects;

import sheep.model.TimeChange;
import sheep.model.entities.Entity;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class LevelUp extends AreaEffect {

	private static final long serialVersionUID = 3262882635444792663L;

	public LevelUp(GameMap map, Location loc) {
		super("LevelUp", map, loc);
	}

	public void applyEffect(Entity e) {
		throw new UnsupportedOperationException();
	}

	public void update(TimeChange msg) {
		
	}
}