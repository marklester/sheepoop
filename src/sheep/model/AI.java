package model;

/**
 * maybe use state pattern for different controller types
 */
public abstract class AI implements model.Observer {
	model.NPC unnamed_NPC_;

	public AI(model.NPC npc, model.GameMap map) {
		throw new UnsupportedOperationException();
	}

	public abstract void update(T msg);
}