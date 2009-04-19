package sheep.model.skills;

import java.awt.event.ActionEvent;
import java.util.List;

import sheep.model.gamemap.Direction;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.model.items.Trap;
import sheep.util.math.Vector2D;

public class RemoveTrap extends PerformableSkill {
	
	private static final long serialVersionUID = -6400640105850953368L;
	public RemoveTrap(){
		super("Remove Trap");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int skill = getCharacter().getSkill(PassiveSkill.DETECT_TRAP);
		int chance = skill - Math.abs((int)(Math.random()*(10-skill)));
		Direction facingDirection = getCharacter().getFacingDirection();
		Vector2D vector = facingDirection.getVector(getCharacter().getLocation());
		Location newLoc = getCharacter().getLocation().addVector(vector);

		// Get neighboring locatables
		List<Locatable> thingsOnTile = getCharacter().getGameMap().get(newLoc);
		int i=0;
		for(Locatable loc:thingsOnTile){
			if(loc instanceof Trap){
				if(chance>(int)((Trap) loc).getDmgAmt()/10){
					((Trap) loc).deActivate();
					getCharacter().hearMessage(getCharacter(), "Deactivated Trap");
				}
			}
		}
		if(i==0)getCharacter().hearMessage(getCharacter(), "Nothing There");
	}

}