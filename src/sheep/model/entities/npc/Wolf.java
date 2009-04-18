package sheep.model.entities.npc;

import sheep.model.Model;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Sneak;

public class Wolf extends NPC {
	private static final long serialVersionUID = 6747342338321148905L;

	public Wolf(Model model, Location loc) {
		super("Wolf", model, loc, new Sneak());
		setAi(new DumbAI(this, model));
	}
}
