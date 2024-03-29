package sheep.model.areaeffects;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.entities.vehicles.Vehicle;
import sheep.model.gamemap.Decal;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.Location;

public class River extends AreaEffect {
	private int myFrequency;
	private Direction direction;
	private Direction reverse;
	private RiverCounter myRivC;
	private Decal myArrow;
	private static final long serialVersionUID = -2338346084817804369L;

	public River(Model model, Location loc,Direction d, Direction reverse, int frequency, RiverCounter rc, Decal myDec) {
		super("River", model, loc);
		this.direction =d;
		this.myFrequency = frequency;
		myRivC = rc;
		this.reverse = reverse;
		myRivC.addRiverToStream(this);
		myArrow = myDec;
		myArrow.setOrientation(d);
	}

	public int getMyFrequency()
	{
		return myFrequency;
	}

	public Direction getDirection()
	{
		return direction;
	}

	public void applyEffect(Entity e) {
//		System.out.println("Adding "+e+" to the stream");
		myRivC.addEntityToStream(e);
	}

	@Override
	//Hack so TPayne can get in river and float
	public void touch(Entity entity) {
		if (entity == getModel().getMover()||(entity instanceof Vehicle)) {
			applyEffect(entity);
		}
	}
	public void reverseFlow()
	{
		Direction temp = direction;
		direction = reverse;
		reverse = temp;
		myArrow.setOrientation(direction);
	}
	@Override
	public void tick() {
	}
	
}