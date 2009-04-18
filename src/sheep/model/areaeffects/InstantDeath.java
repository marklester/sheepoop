package sheep.model.areaeffects;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Location;

public class InstantDeath extends AreaEffect {

	private static final long serialVersionUID = 7991051797350750281L;

	public InstantDeath(Model model, Location loc) {
		super("InstantDeath", model, loc);
	}
	
	public void applyEffect(Entity e) {
		e.affectStat(StatType.DAMAGE, e.getStat(StatType.LIFE));
	}

	@Override
	public void tick() {
		
	}
}