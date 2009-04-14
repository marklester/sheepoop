package sheep.model.entities;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Occupation;

public class Avatar extends Character {
	private static final long serialVersionUID = -7609642508399494950L;
	
	public Avatar() {
		
	}
	
	public Avatar(String id, GameMap map, Location loc, Occupation occupation) {
		super(id, map, loc, occupation);
	}

	



}