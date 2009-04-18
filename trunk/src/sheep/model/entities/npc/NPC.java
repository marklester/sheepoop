package sheep.model.entities.npc;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Occupation;

public class NPC extends Character {

	private static final long serialVersionUID = 3556634534829274948L;

	private final Model model;
	private AI ai;

	public NPC(String id, Model model, Location loc, Occupation occupation) {
		super(id, model, loc, occupation);
		this.model = model;
	}

	public boolean blocks(Entity entity) {
		if (entity == model.getAvatar()) {
			model.getAvatar().setInteractingCharacter(this);
		}
		return true;
	}

	public void talk(Character character) {
		// If we want, we can have this forward talk() onto AI instead
		character.hearMessage(this, "Hi my name is " + this.getID() + ", what's up?");
	}

	public void setAi(AI ai) {
		this.ai = ai;
	}
	
	@Override
	public void setInteractingCharacter(Character character) {
		super.setInteractingCharacter(character);
		
		// Check if we are trying to move into the avatar, and possibly attack 
		if (character == model.getAvatar()) {
			ai.bumpedIntoAvatar(model.getAvatar());
		}
	}

	@Override
	public void die() {
		this.setAi(null);
		this.getGameMap().remove(getLocation(),this);
		setLocation(null);
	}
}