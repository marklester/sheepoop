package sheep.model.entities.vehicles;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.entities.npc.NPC;
import sheep.model.gamemap.Location;

public class TPBoat extends Boat
{
	private static final long serialVersionUID = -6066976814335472704L;
	NPC myTPayne;
	public TPBoat(Model model, Location loc)
	{
		super(model, loc);
	}

	public void setTPayne(NPC npc)
	{
		myTPayne= npc;
	}
	@Override
	public boolean blocks(Entity entity) {		
		if (entity == getModel().getAvatar()||entity==myTPayne) {
			return false;
		}
		return true;
	}
}
