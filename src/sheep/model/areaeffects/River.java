package sheep.model.areaeffects;

import sheep.model.Model;
import sheep.model.Time;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Decal;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.Location;

public class River extends AreaEffect {
	private int myFrequency;
	private Direction direction;
	private RiverCounter myRivC;
	private Decal myArrow;
	private static final long serialVersionUID = -2338346084817804369L;

	public River(Model model, Location loc,Direction d, int frequency, RiverCounter rc, Decal myDec) {
		super("River", model, loc);
		this.direction =d;
		this.myFrequency = frequency;
		myRivC = rc;
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
		myRivC.addEntityToStream(e);
	}

	public void reverseFlow()
	{
		this.direction = this.direction.opposite();
		myArrow.setOrientation(this.direction);
	}
	@Override
	public void tick() {
	}
	
}