package sheep.model.entities;

import sheep.model.GameMap;
import sheep.model.Observer;
import sheep.model.TimeChange;

/**
 * maybe use state pattern for different controller types
 */
public abstract class AI implements Observer<TimeChange> {
	NPC npc;

	public AI(NPC npc, GameMap map) {
		throw new UnsupportedOperationException();
	}

	public abstract void update(TimeChange msg);
}