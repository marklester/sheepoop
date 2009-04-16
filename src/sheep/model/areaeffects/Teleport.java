package sheep.model.areaeffects;

import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
/**
 * Level Up does need to register to time because it only gets used once
 * @author mlester
 *
 */
public class Teleport extends AreaEffect {
	private Location to;
	private static final long serialVersionUID = 3262882635444792663L;

	public Teleport(GameMap map, Location loc,Location to) {
		super("LevelUp", map, loc);
		this.to = to;
	}

	public void applyEffect(Entity e) {
		e.setLocation(to);
	}

	//@Override
	public void tick() {}
	
}