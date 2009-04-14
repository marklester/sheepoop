package sheep.model.areaeffects;

import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class TakeDamage extends AreaEffect {

	private static final long serialVersionUID = -1922478825658683800L;


	private int myFrequency;
	private int mySeverity;
	private int ticksToEffect;
	
	
	public TakeDamage(GameMap map, Location loc, int frequency, int severity) {
		super("HealDamage", map, loc);
		myFrequency = frequency;
		mySeverity = severity;
		ticksToEffect = myFrequency;
	}

	public void applyEffect(Entity e) {
		e.affectStat(StatType.LIFE, -mySeverity);
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