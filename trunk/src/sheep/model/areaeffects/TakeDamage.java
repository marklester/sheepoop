package sheep.model.areaeffects;

import sheep.model.Model;
import sheep.model.Time;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Location;

public class TakeDamage extends AreaEffect {

	private static final long serialVersionUID = -1922478825658683800L;

	private int myFrequency;
	private int mySeverity;
	private int ticksToEffect;
	
	public TakeDamage(Model model, Location loc, int frequency, int severity) {
		super("TakeDamage", model, loc);
		myFrequency = frequency;
		mySeverity = severity;
		ticksToEffect = myFrequency;
		Time.getInstance().registerObserver(this);
	}

	public void applyEffect(Entity e) {
		e.affectStat(StatType.DAMAGE, mySeverity);
	}

	@Override
	public void tick() {
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