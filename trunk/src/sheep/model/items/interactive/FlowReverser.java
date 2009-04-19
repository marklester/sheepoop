package sheep.model.items.interactive;

import sheep.model.Model;
import sheep.model.areaeffects.RiverCounter;
import sheep.model.entities.Character;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;

public class FlowReverser extends Takeable
{
	private RiverCounter myRc;
	private static final long serialVersionUID = 1L;

	public FlowReverser(Model model, Location loc, RiverCounter rc)
	{
		super("Flow Reverser", model, loc, 5000);
		myRc = rc;
	}

	@Override
	public void use(Character entity)
	{
		myRc.switchAll();
	}
	
}