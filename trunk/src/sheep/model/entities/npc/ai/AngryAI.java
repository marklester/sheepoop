package sheep.model.entities.npc.ai;

import sheep.model.Model;
import sheep.model.entities.Avatar;
import sheep.model.entities.StatType;
import sheep.model.entities.npc.NPC;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.Location;

public class AngryAI extends AI {

	private static final long serialVersionUID = -576367827163651816L;

	public AngryAI(Model model) {
		super(model);

		//		int dx = 100 - npc.getHostility(); 
		//		
		//		dx = ( dx > 25 ) ? dx - 25 : 0;
		//		
		//		npc.affectHostility( dx );
	}

	public void tick() {

		if(getNPC()!=null)
		{
			Direction dirToAvatar = null;
			Avatar myAv = this.getModel().getAvatar();
			Location avatarLoc = myAv.getLocation();	// I'm too good to care about LoD!
			Location npcLoc = this.getNPC().getLocation();

			if(Math.abs(avatarLoc.getX() - npcLoc.getX())<=4-myAv.getStat(StatType.STEALTH)&& Math.abs(avatarLoc.getY() - npcLoc.getY())<=4-myAv.getStat(StatType.STEALTH))
			{
				if (Math.abs(avatarLoc.getX() - npcLoc.getX()) > Math.abs(avatarLoc.getY() - npcLoc.getY())) {
					// move left or right
					if (avatarLoc.getX() < npcLoc.getX()) { 
						// avatar is left
						if (avatarLoc.getY() < npcLoc.getY()) {
							// avatar is up
							dirToAvatar = Direction.NW;
						} else {
							// avatar is down
							dirToAvatar = Direction.SW;
						}
					} else {
						// avatar is right
						if (avatarLoc.getY() < npcLoc.getY()) {
							// avatar is up
							dirToAvatar = Direction.NE;
						} else {
							// avatar is down
							dirToAvatar = Direction.SE;
						}
					}
				} else {
					if (avatarLoc.getY() < npcLoc.getY()) {
						// avatar is up
						dirToAvatar = Direction.N;
					} else {
						// avatar is down
						dirToAvatar = Direction.S;
					}
				}

				this.getNPC().startMoving(dirToAvatar);
			}
		}
	}

	@Override
	public void bumpedIntoAvatar(Avatar avatar) {
		avatar.hearMessage(getNPC(), "Hi, I am " + getNPC().getID() + " and I'm about to attack you");
		avatar.affectStat(StatType.DAMAGE, 1);
	}

}