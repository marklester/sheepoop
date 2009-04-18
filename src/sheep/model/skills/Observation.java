package sheep.model.skills;

import java.awt.event.ActionEvent;
import java.util.Vector;

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
		Vector<Locatable> thingsOnTile = getCharacter().getGameMap().get(newLoc);
		for(Locatable loc:thingsOnTile){
			Character c;
			if(loc instanceof sheep.model.entities.Character){
				
			}
		}
		
	}
}