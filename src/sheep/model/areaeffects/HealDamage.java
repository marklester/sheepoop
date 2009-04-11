package sheep.model.areaeffects;

import sheep.model.TimeChange;
import sheep.model.entities.Entity;

public class HealDamage extends AreaEffect {

	private static final long serialVersionUID = -4014549164957535326L;

	public HealDamage(String id) {
		super(id);
	}

	public void applyEffect(Entity e) {
		throw new UnsupportedOperationException();
	}

	public void update(TimeChange msg) {
		throw new UnsupportedOperationException();
	}
}