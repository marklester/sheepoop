package sheep.model.areaeffects;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Location;
/**
 * Level Up does need to register to time because it only gets used once
 * @author mlester
 *
 */
public class LevelUp extends AreaEffect {
	private boolean used;
	private static final long serialVersionUID = 3262882635444792663L;

	public LevelUp(Model model, Location loc) {
		super("LevelUp", model, loc);
	}

	public void applyEffect(Entity e) {
		if(!used){
			int pexp = e.getStat(StatType.EXPERIENCE);
			e.affectStat(StatType.EXPERIENCE, 1000);
			if(e.getStat(StatType.EXPERIENCE)>pexp){
				used = true;
			}
		}
	}

	//@Override
	public void tick() {}
	
}