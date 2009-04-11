package sheep.model.entities;

import sheep.model.TimeChange;
import sheep.model.gamemap.GameMap;

public class DumbAI extends AI {

	private static final long serialVersionUID = 3836274916586137446L;

	public DumbAI(NPC npc, GameMap map) {
		super(npc, map);
	}

	public void update(TimeChange msg) {

	}
}