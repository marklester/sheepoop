package sheep.model.entities;

import sheep.model.Model;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Occupation;

public class NPC extends Character {

	private static final long serialVersionUID = 3556634534829274948L;

	private final Model model;
	private AI ai;
	
	public NPC(String id, GameMap map, Location loc, Occupation occupation, Model model) {
		super(id, map, loc, occupation);
		this.model = model;
	}

	public boolean blocks(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public void talk(Character character) {
		throw new UnsupportedOperationException();
	}

}