package sheep.model.entities.npc;

import sheep.model.Model;
import sheep.model.entities.npc.ai.TPayneAI;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Smasher;
import sheep.view.util.ResourceLoader;

public class TPayne extends NPC
{
	private static final long serialVersionUID = 8114118034947722340L;

	public TPayne(Model model, Location loc, TPayneAI ai)
	{
		super("TPain", model, loc, new Smasher(), 0, ai,ai);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void die() {
		super.die();
		ResourceLoader.getInstance().getTPainPlayer().close();
	}
}
