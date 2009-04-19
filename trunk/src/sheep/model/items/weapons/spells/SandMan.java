package sheep.model.items.weapons.spells;

import sheep.model.Model;
import sheep.model.entities.npc.NPC;
import sheep.model.entities.npc.ai.SleepState;
import sheep.model.gamemap.Location;

public class SandMan extends Enchantment
{
	private static final long serialVersionUID = 8932585310125306826L;

	public SandMan(Model model, Location loc)
	{
		super("Sand Man", model, loc, 0, 8, 100);
	}
	@Override
	public void applyEffect(NPC npc) {
		new SleepState(1000,npc);
	}
}
