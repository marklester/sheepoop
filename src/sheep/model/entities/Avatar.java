package sheep.model.entities;

import sheep.model.GameStateType;
import sheep.model.Model;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.items.weapons.CrossBow;
import sheep.model.occupations.Occupation;

public class Avatar extends Character {
	private static final long serialVersionUID = -7609642508399494950L;
	
	private Model model;
	
	public Avatar(String id, GameMap map, Location loc, Occupation occupation, Model model) {
		super(id, map, loc, occupation);
		this.model = model;
		
		new CrossBow(map,loc).use(this);	// TODO for testing
		CrossBow a = new CrossBow(map,loc);
		CrossBow b = new CrossBow(map,loc);
		CrossBow c = new CrossBow(map,loc);
		CrossBow d = new CrossBow(map,loc);
		this.addToInventory(a);
		this.addToInventory(b);
		this.addToInventory(c);
		this.addToInventory(d);
	}

	public int getRadiusOfVisibility() {
		if (getStat(StatType.LIFE) == 0) {
			return 0;
		}
		return Math.max(1, 7 - getStat(StatType.MAX_LIFE) / getStat(StatType.LIFE));
	}

	/**
	 * Teleport back to starting point.  This should only be called by CharacterStats.
	 */
	public void die() {
		this.notifyStatChangeObservers(new StatChange(StatType.LIVES_LEFT, -1));
		if (getStat(StatType.LIVES_LEFT) == 0) {
			model.setState(GameStateType.GAME_OVER);
		} else {
			this.setLocation(getStartingLocation());
		}
	}
	
	
}