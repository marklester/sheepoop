package sheep.model.entities.npc;

import java.util.HashMap;
import java.util.Vector;
import java.util.Map.Entry;

import sheep.model.Model;
import sheep.model.entities.Avatar;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;

public class AngryAI extends AI {

	private static final long serialVersionUID = -576367827163651816L;
	
	public AngryAI(NPC npc, Model model) {
		super(npc, model);
	}

	public void tick() {

		Direction dirToAvatar = null;
		Location avatarLoc = this.getModel().getAvatar().getLocation();	// I'm too good to care about LoD!
		Location npcLoc = this.getNPC().getLocation();
		
		// Only try to find avatar if its within radius of 5
		HashMap<Location, Vector<Locatable>> neighbors = this.getGameMap().getMapSubset(npcLoc, 5);
		boolean avatarFound = false;
		for (Entry<Location, Vector<Locatable>> locatables : neighbors.entrySet()) {
			for (Locatable locatable : locatables.getValue()) {			
				if (locatable == this.getModel().getMover()) {
					avatarFound = true;
				}
			}
		}
		if (!avatarFound) {
			return;
		}
		
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

	@Override
	public void bumpedIntoAvatar(Avatar avatar) {
		avatar.hearMessage(getNPC(), "Hi, I am " + getNPC().getID() + " and I'm about to attack you");
		avatar.affectStat(StatType.DAMAGE, 1);
	}

}