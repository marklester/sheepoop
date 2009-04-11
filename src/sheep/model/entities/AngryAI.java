package sheep.model.entities;

import sheep.model.GameMap;
import sheep.model.TimeChange;

public class AngryAI extends AI {

	public AngryAI(NPC npc, GameMap map) {
		super(npc, map);
	}

	public void tick() {
		throw new UnsupportedOperationException();
	}

	public void update(Object object) {
		throw new UnsupportedOperationException();
	}

	public void update(TimeChange msg) {
		throw new UnsupportedOperationException();
	}
}