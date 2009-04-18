package sheep.model.areaeffects;

import sheep.model.Model;
import sheep.model.Time;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.Location;

public class River extends AreaEffect {
	private int myFrequency;
	private int force;
	private Direction direction;
	private int ticksToEffect;
	private static final long serialVersionUID = -2338346084817804369L;

	public River(Model model, Location loc,Direction d) {
		super("River", model, loc);
		this.direction =d;
		this.myFrequency = 10;
		this.ticksToEffect=this.myFrequency;
		Time.getInstance().registerObserver(this);
	}

	public void applyEffect(Entity e) {
		System.out.println("River "+direction);
		int speed = e.getSpeed();
		e.stopMoving();
		if(e.isMoving()){
			
		}else{
			e.startMoving(direction);
			e.stopMoving();
		}
		//se.affectStat(StatType.SPEED, mySeverity);
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