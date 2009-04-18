package sheep.model.areaeffects;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Location;

public class River extends AreaEffect {

	private static final long serialVersionUID = -2338346084817804369L;

	public River(Model model, Location loc) {
		super("River", model, loc);
	}

	public void applyEffect(Entity e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void tick() {
	
	}
	
}