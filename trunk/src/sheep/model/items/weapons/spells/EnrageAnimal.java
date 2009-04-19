package sheep.model.items.weapons.spells;

import sheep.model.Model;
import sheep.model.entities.npc.NPC;
import sheep.model.gamemap.Location;

public class EnrageAnimal extends Enchantment
{
	private static final long serialVersionUID = 8932585310125306826L;

	public EnrageAnimal(Model model, Location loc)
	{
		super("Enrage Animal", model, loc, 0, 8, 100);
	}
	@Override
	public void applyEffect(NPC npc) {
		npc.affectHostility(100);
		System.out.println("Applied effect");
	}
}
