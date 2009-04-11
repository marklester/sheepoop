package sheep.model.entities;

import java.io.Serializable;

import sheep.model.Observer;
import sheep.model.TimeChange;
import sheep.model.gamemap.GameMap;

/**
 * 
 * @author Phil Freo
 */
public abstract class AI implements Observer<TimeChange>, Serializable {
	private static final long serialVersionUID = 7551024229134848584L;
	
	private final NPC npc;
	private final GameMap map;

	public AI(NPC npc, GameMap map) {
		this.npc = npc;
		this.map = map;
	}

	public abstract void update(TimeChange msg);
	
	public NPC getNPC() {
		return this.npc;
	}
	
	public GameMap getGameMap() {
		return this.map;
	}
}