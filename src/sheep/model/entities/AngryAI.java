package sheep.model.entities;

import sheep.model.GameMap;
import sheep.model.TimeChange;

public class AngryAI extends AI {

	private static final long serialVersionUID = -576367827163651816L;

	public AngryAI(NPC npc, GameMap map) {
		super(npc, map);
	}

	public void update(TimeChange msg) {
		throw new UnsupportedOperationException();
	}
}