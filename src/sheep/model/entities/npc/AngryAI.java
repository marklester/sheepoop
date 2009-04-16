package sheep.model.entities.npc;

import sheep.model.entities.Avatar;
import sheep.model.entities.StatType;
import sheep.model.gamemap.GameMap;

public class AngryAI extends AI {

	private static final long serialVersionUID = -576367827163651816L;

	public AngryAI(NPC npc, GameMap map) {
		super(npc, map);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void bumpedIntoAvatar(Avatar avatar) {
		avatar.affectStat(StatType.DAMAGE, 5);
	}

}