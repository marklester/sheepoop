package sheep.model.entities.npc;

import sheep.model.Model;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Summoner;

public class AngryWolf extends NPC {
	private static final long serialVersionUID = 6747342338321148905L;

	public AngryWolf(GameMap map, Location loc, Model model) {
		super("Wolf", map, loc, new Summoner(), model);
		setAi(new AngryAI(this, model));
	}
}
