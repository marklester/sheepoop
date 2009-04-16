package sheep.model.entities.npc;

import java.io.Serializable;

import sheep.model.TimeObserver;
import sheep.model.entities.Avatar;
import sheep.model.gamemap.GameMap;

/**
 * 
 * @author Phil Freo
 */
public abstract class AI implements TimeObserver, Serializable {
	private static final long serialVersionUID = 7551024229134848584L;
	
	private final NPC npc;
	private final GameMap map;

	public AI(NPC npc, GameMap map) {
		this.npc = npc;
		this.map = map;
	}

	public abstract void tick();
	
	public NPC getNPC() {
		return this.npc;
	}
	
	public GameMap getGameMap() {
		return this.map;
	}

	public abstract void bumpedIntoAvatar(Avatar avatar);
}