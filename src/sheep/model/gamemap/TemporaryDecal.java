package sheep.model.gamemap;

import sheep.model.Model;
import sheep.model.Time;
import sheep.model.TimeObserver;

/**
 * @param period - Do something every this many ticks
 * @param duration - How many period to exist before it gets distroyed
 * @author Mark Lester
 */
public class TemporaryDecal extends Decal implements TimeObserver{
	private static final long serialVersionUID = -6244165739481933022L;
	Direction orientation;
	int periodtick=0; //do something every period
	int currenttick=0;//the current time;
	int duration;
	
	public TemporaryDecal(String id, Model model, Location loc,int period,int duration) {
		super(id, model, loc);
		this.periodtick = period;
		this.duration = duration;
		orientation = null;
		Time.getInstance().registerObserver(this);
	}

	public Direction getOrientation(){
		return orientation;
	}

	public void setOrientation(Direction orientation){
		this.orientation = orientation;
	}

	public void accept(LocatableVisitor v) {
		v.visit(this);
	}

	@Override
	public void tick() {
		if(currenttick==periodtick){
			currenttick=0;
			duration--;
		}
		currenttick++;
		if(duration<=0){
			dispose();
		}
	}
	public void dispose(){
		Time.getInstance().removeObserver(this);
		getModel().getGameMap().remove(getLocation(), this);
	}
}