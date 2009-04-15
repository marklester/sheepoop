package sheep.model.entities.npc;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Sneak;

public class Wolf extends NPC {
	public Wolf(GameMap map,Location loc){
		super("Wolf",map,loc,new Sneak(),null);
		setAi(new DumbAI(this,null));
	}
}
