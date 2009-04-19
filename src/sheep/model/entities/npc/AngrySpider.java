package sheep.model.entities.npc;

import sheep.model.Model;
import sheep.model.entities.StatType;
import sheep.model.entities.npc.ai.AngryAI;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Summoner;

public class AngrySpider extends NPC {
	private static final long serialVersionUID = 6747342338321148905L;

	public AngrySpider(Model model, Location loc) {
		super("Spider", model, loc, new Summoner());
		setAi(new AngryAI(this, model));
		this.getStats().change(StatType.SPEED, - 19);
		this.getStats().change(StatType.MONEY, 100);
	}
}
