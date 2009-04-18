package sheep.model.areaeffects;

import sheep.model.Model;
import sheep.model.Time;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Location;
/**
 * Level Up does need to register to time because it only gets used once
 * @author mlester
 *
 */
public class LevelUp extends AreaEffect {
	private int myFrequency;
	private int ticksToEffect;
	private static final long serialVersionUID = 3262882635444792663L;

	public LevelUp(Model model, Location loc) {
		super("LevelUp", model, loc);
		this.myFrequency=100;
		this.ticksToEffect=this.myFrequency;
		Time.getInstance().registerObserver(this);
	}

	public void applyEffect(Entity e) {
			e.affectStat(StatType.EXPERIENCE, 1000);
	}

	//@Override
	public void tick(){
		if(getLastEntity()==null){
			ticksToEffect = myFrequency;
		}else if(ticksToEffect>0){
			ticksToEffect--;
		}else{
			if(getLastEntity().getLocation().equals(this.getLocation())){
				applyEffect(getLastEntity());
			}
			ticksToEffect=myFrequency;
		}
	}
	
}