package sheep.model.entities.npc;

import sheep.model.Model;
import sheep.model.entities.Avatar;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Direction;

public class DumbAI extends AI {

	private static final long serialVersionUID = 3836274916586137446L;

	public DumbAI(NPC npc, Model model) {
		super(npc, model);
	}

	public void tick() {
		int state = (int) (Math.random() * 6);
		if (state == 6) {
			this.getNPC().stopMoving();
		} else {
			this.getNPC().startMoving(Direction.values()[state]);
		}
	}

	@Override
	public void bumpedIntoAvatar(Avatar avatar) {
		avatar.hearMessage(getNPC(), "Hi, I am " + getNPC().getID() + " and I'm about to attack you");
		avatar.affectStat(StatType.DAMAGE, 5);
	}
}