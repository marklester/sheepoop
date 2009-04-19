package sheep.model.entities.npc.ai;

import java.io.Serializable;

import sheep.model.Model;
import sheep.model.Time;
import sheep.model.TimeObserver;
import sheep.model.entities.Avatar;
import sheep.model.entities.npc.NPC;
import sheep.model.gamemap.GameMap;

/**
 * 
 * @author Phil Freo
 */
public abstract class AI implements TimeObserver, Serializable {
	private static final long serialVersionUID = 7551024229134848584L;
	private NPC npc;
	private final Model model;

	
	public AI(NPC npc, Model model) {
		this.npc = npc;
		this.model = model;
		Time.getInstance().registerObserver(this);
	}

	public abstract void tick();
	
	public NPC getNPC() {
		return this.npc;
	}
	
	public GameMap getGameMap() {
		return this.model.getGameMap();
	}
	
	public Model getModel() {
		return this.model;
	}
	public void setNPC(NPC npc){
		this.npc = npc;
	}
	public abstract void bumpedIntoAvatar(Avatar avatar);
}