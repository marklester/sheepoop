package sheep.model.items.useable;

import sheep.model.Model;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;

public abstract class Useable extends Takeable
{

	private static final long serialVersionUID = 1L;

	public Useable(String id, Model model, Location loc)
	{
		super(id, model, loc);
		// TODO Auto-generated constructor stub
	}

}
