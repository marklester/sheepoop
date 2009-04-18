package sheep.model.entities;

import sheep.model.GameStateType;
import sheep.model.Model;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Occupation;

public class Avatar extends Character{
	private static final long serialVersionUID = -7609642508399494950L;
	
	private Model model;
	
	@Override
	public boolean canClimb()
	{
		return false;
	}

	@Override
	public boolean canSwim()
	{
		return false;
	}

	@Override
	public boolean canWalk()
	{
		return true;
	}
	
	public Avatar(String id, Model model, Location loc, Occupation occupation) {
		super(id, model, loc, occupation);
		this.model = model;
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