package sheep.model.entities;

import sheep.model.GameMap;
import sheep.model.TimeChange;

public class DumbAI extends AI {

	private static final long serialVersionUID = 3836274916586137446L;

	public DumbAI(NPC npc, GameMap map) {
		super(npc, map);
	}

	@Override
	public void update(TimeChange msg) {
	}
}