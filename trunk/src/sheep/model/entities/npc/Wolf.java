package sheep.model.entities.npc;

import sheep.model.Model;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Sneak;

public class Wolf extends NPC {
	private static final long serialVersionUID = 6747342338321148905L;

	public Wolf(GameMap map, Location loc, Model model) {
		super("Wolf", map, loc, new Sneak(), model);
		setAi(new DumbAI(this, map));
	}
}
