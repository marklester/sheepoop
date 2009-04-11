package sheep.model.entities;

import sheep.model.GameMap;
import sheep.model.TimeChange;


public class DumbAI extends AI {

	public DumbAI(NPC npc, GameMap map) {
		super(npc, map);
	}

	public void tick() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(TimeChange msg) {
	}
}