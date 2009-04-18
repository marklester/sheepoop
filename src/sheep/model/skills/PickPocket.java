package sheep.model.skills;

import java.awt.event.ActionEvent;
import java.util.Vector;

import sheep.model.entities.StatType;
import sheep.model.entities.npc.NPC;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.util.math.Vector2D;

public class PickPocket extends PerformableSkill {
	private static final long serialVersionUID = 8040067029170038804L;
	public PickPocket(){
		super("Pick Pocket");
	}
	//@Override
	public void actionPerformed(ActionEvent e) {
		Direction facingDirection = getCharacter().getFacingDirection();
		Vector2D vector = facingDirection.getVector(getCharacter().getLocation());
		Location newLoc = getCharacter().getLocation().addVector(vector);
		// Get neighboring locatables
		Vector<Locatable> thingsOnTile = getCharacter().getGameMap().get(newLoc);
		int i=0;
		for(Locatable loc:thingsOnTile){
			if(loc instanceof sheep.model.entities.Character){
				NPC npc = (NPC)loc;
				int money = npc.getStat(StatType.MONEY);
				int moneystolen = (int)(money*(.1 * points));
				npc.affectStat(StatType.MONEY, -moneystolen);
				getCharacter().affectStat(StatType.MONEY, moneystolen);
				getCharacter().hearMessage(getCharacter(), "You Stole "+moneystolen+" monies");
				i++;
			}
		}
		if(i==0)getCharacter().hearMessage(getCharacter(), "Nobody To steal from");
	}

	
}