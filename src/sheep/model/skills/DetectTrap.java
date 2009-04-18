package sheep.model.skills;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.model.items.Trap;


public class DetectTrap extends PerformableSkill {
	
	private static final long serialVersionUID = -6400640105850953368L;
	public DetectTrap(){
		super("Detect Trap");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Location center = getCharacter().getLocation();
		int radius = getCharacter().getSkill(PassiveSkill.DETECT_TRAP);
		// Get neighboring locatables
		getCharacter().hearMessage(getCharacter(), " is detecting Traps");
		Map<Location, List<Locatable>> tiles = getCharacter().getGameMap().getMapSubset(center, radius);
		for (Entry<Location, List<Locatable>> entry : tiles.entrySet()) {
			Location loc = entry.getKey();
			List<Locatable> locatables = entry.getValue();
			for(Locatable l : locatables){
				if(l instanceof Trap){
					((Trap) l).showTrap();
				}
			}
		}
	}

}