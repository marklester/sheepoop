package sheep.model.items.interactive;

import sheep.model.Model;
import sheep.model.Time;
import sheep.model.entities.Character;
import sheep.model.entities.npc.ai.TPayneAI;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;

public class FreeBoatRideFor3 extends Takeable
{

	private static final long serialVersionUID = 1L;

	boolean toggle;
	
	private TPayneAI myTp;
	public FreeBoatRideFor3(Model model, Location loc, TPayneAI myTp)
	{
		super("Free boat", model, loc, 5000);
		this.myTp = myTp;
		toggle = false;
	}

	@Override
	public void use(Character entity)
	{
		if(!toggle)
		{
			Time.getInstance().registerObserver(myTp);
			toggle = true;
		}
		else
		{
			Time.getInstance().removeObserver(myTp);
			toggle = false;
		}
	}
	
}