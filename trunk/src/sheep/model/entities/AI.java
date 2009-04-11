package sheep.model.entities;

import sheep.model.GameMap;
import sheep.model.Observer;
import sheep.model.TimeChange;

/**
 * maybe use state pattern for different controller types
 */
public abstract class AI implements Observer<TimeChange> {
	private final NPC npc;
	private final GameMap map;

	public AI(NPC npc, GameMap map) {
		this.npc = npc;
		this.map = map;
	}

	public abstract void update(TimeChange msg);
}