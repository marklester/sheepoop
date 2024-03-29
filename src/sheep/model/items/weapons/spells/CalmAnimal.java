package sheep.model.items.weapons.spells;

import sheep.model.Model;
import sheep.model.entities.StatType;
import sheep.model.entities.npc.NPC;
import sheep.model.gamemap.Location;

public class CalmAnimal extends Enchantment
{
	private static final long serialVersionUID = 8932585310125306826L;

	public CalmAnimal(Model model, Location loc)
	{
		super("Calm Animal", model, loc, 0, 8, 100);
	}
	@Override
	public void applyEffect(NPC npc) {
		if(getUser().getStat(StatType.MANA)> 4)
		{
			getUser().affectStat(StatType.MANA_USED, -5);
			npc.affectHostility(-100);
		}
	}
	@Override
	public int getDamageWith()
	{
		return 0;
	}
}
