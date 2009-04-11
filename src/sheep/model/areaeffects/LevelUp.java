package sheep.model.areaeffects;

import sheep.model.TimeChange;
import sheep.model.entities.Entity;

public class LevelUp extends AreaEffect {

	private static final long serialVersionUID = 3262882635444792663L;

	public LevelUp(String id) {
		super(id);
	}

	public void applyEffect(Entity e) {
		throw new UnsupportedOperationException();
	}

	public void update(TimeChange msg) {
		throw new UnsupportedOperationException();
	}
}