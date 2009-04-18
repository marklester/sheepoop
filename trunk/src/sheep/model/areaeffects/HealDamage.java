package sheep.model.areaeffects;

import sheep.model.Model;
import sheep.model.Time;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Location;

public class HealDamage extends AreaEffect {

	private static final long serialVersionUID = -4014549164957535326L;

	private int myFrequency;
	private int mySeverity;
	private int ticksToEffect;
	
	
	public HealDamage(Model model, Location loc, int frequency, int severity) {
		super("HealDamage", model, loc);
		myFrequency = frequency;
		mySeverity = severity;
		ticksToEffect = myFrequency;
		Time.getInstance().registerObserver(this);
	}

	public void applyEffect(Entity e) {
		e.affectStat(StatType.DAMAGE, -mySeverity);
	}

	@Override
	public void tick() {
		if(getLastEntity()==null)
		{
			ticksToEffect = myFrequency;
		}
		else if(ticksToEffect>0)
		{
			ticksToEffect--;
		}
		else
		{
			if(getLastEntity().getLocation().equals(this.getLocation()))
			{
				applyEffect(getLastEntity());
			}
			ticksToEffect=myFrequency;
		}
	}
}