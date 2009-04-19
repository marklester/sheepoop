package sheep.model.skills;

import java.awt.event.ActionEvent;
import java.util.List;

import sheep.model.entities.StatType;
import sheep.model.entities.npc.NPC;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.util.math.Vector2D;

public class Observation extends PerformableSkill {

	private static final long serialVersionUID = 8591691388338199436L;
	public Observation(){
		super("Observation");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Direction facingDirection = getCharacter().getFacingDirection();
		Vector2D vector = facingDirection.getVector(getCharacter().getLocation());
		Location newLoc = getCharacter().getLocation().addVector(vector);

		// Get neighboring locatables
		List<Locatable> thingsOnTile = getCharacter().getGameMap().get(newLoc);
		int i=0;
		for(Locatable loc:thingsOnTile){
			if(loc instanceof sheep.model.entities.Character){
				NPC npc = (NPC)loc;
				StatType st = StatType.random();
				int randomstat = npc.getStat(st);
				int range = 10-points;
				int low = randomstat-((int)(Math.random()*range));
				int high= randomstat+((int)(Math.random()*range));
				getCharacter().hearMessage(getCharacter(), "Observation! Character has "+st+" between "+low+" and "+high);
				i++;
			}
		}
		if(i==0)getCharacter().hearMessage(getCharacter(), "Nobody There");
	}
}