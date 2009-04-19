package sheep.model.entities.npc;

import sheep.model.Model;
import sheep.model.entities.StatType;
import sheep.model.entities.npc.ai.DumbAI;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Sneak;

public class Spider extends NPC {
	private static final long serialVersionUID = 6747342338321148905L;

	public Spider(Model model, Location loc) {
		super("Spider", model, loc, new Sneak());
		setAi(new DumbAI(this, model));
		this.getStats().change(StatType.MONEY, 100);
	}
}
