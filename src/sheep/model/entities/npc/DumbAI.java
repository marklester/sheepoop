package sheep.model.entities.npc;

import sheep.model.Time;
import sheep.model.entities.Avatar;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.GameMap;

public class DumbAI extends AI {

	private static final long serialVersionUID = 3836274916586137446L;
	private int state;

	public DumbAI(NPC npc, GameMap map) {
		super(npc, map);
		state = 0;
		Time.getInstance().registerObserver(this);
	}

	public void tick() {
		state = (int) (Math.random() * 6);
		if (state == 6) {
			this.getNPC().stopMoving();
		} else {
			this.getNPC().startMoving(Direction.values()[state]);
		}
	}

	@Override
	public void bumpedIntoAvatar(Avatar avatar) {
		avatar.affectStat(StatType.DAMAGE, 5);
	}
}