package sheep.model.entities;

import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Occupation;

public class Avatar extends Character {
	
	public Avatar() {
		//testing purposes...
	}

	public Avatar(String id, GameMap map, Location loc, Occupation occupation) {
		super(id, map, loc, occupation);
	}

	private static final long serialVersionUID = -7609642508399494950L;



}