package sheep.model.areaeffects;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Location;

/**
 * Level Up does need to register to time because it only gets used once
 * @author mlester
 * 
 */
public class Teleport extends AreaEffect {

	private static final long serialVersionUID = 3262882635444792663L;
	private final Model model;
	private Location to;

	public Teleport(Model model, Location loc, Location to) {
		super("LevelUp", model, loc);
		this.to = to;
		this.model = model;
	}

	public void applyEffect(Entity e) {
		// Only the user should teleport (no wolves!)
		if (e != model.getMover()) {
			return;
		}
		
		// Teleport
		e.setLocation(to);
	}

	@Override
	public void tick() {
	}

}