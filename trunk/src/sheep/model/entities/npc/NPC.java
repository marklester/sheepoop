package sheep.model.entities.npc;

import sheep.model.GameStateType;
import sheep.model.Model;
import sheep.model.Time;
import sheep.model.entities.Character;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.entities.npc.ai.AI;
import sheep.model.gamemap.Location;
import sheep.model.occupations.Occupation;

public class NPC extends Character {

	private static final long serialVersionUID = 3556634534829274948L;

	boolean dead = false;
	private final Model model;
	private int hostility;
	private AI ai;
	
	
	public NPC(String id, Model model, Location loc, Occupation occupation) {
		super(id, model, loc, occupation);
		this.model = model;
		hostility = 0;
	}

	@Override
	public boolean blocks(Entity entity) {
		if (entity == model.getAvatar()) {
			model.getAvatar().setInteractingCharacter(this);
			model.setState(GameStateType.PAUSED_ACTION_MENU);
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
	
	public int getHostility() {
		return hostility;
	}
	
	public void affectHostility( int changeAmt ) {
		this.hostility = hostility + changeAmt;
		this.hostility = ( hostility < 0 ) ? 0 : hostility;
		this.hostility = ( hostility > 100) ? 100 : hostility;
		System.out.println("Hostility: " + hostility);
	}
	
	public void weaponDamage( int damage )
	{
		//(hopefully) linear hostility increase as health goes down.
		int lifeLeft = (int) ( ( ( ( double) this.getStat( StatType.DAMAGE) + damage)  / (double) this.getStat( StatType.MAX_LIFE ) )* 100.0);
		
		int dx = lifeLeft - this.getHostility();
		this.affectHostility( (dx > 0) ? dx : 0  );
		
		super.weaponDamage( damage );
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
		dead = true;
		Time.getInstance().removeObserver(ai);
		//sai.setNPC(null);
		ai=null;
		this.getGameMap().remove(getLocation(),this);
		setLocation(null);
	}
	@Override
	public boolean isDead()
	{
		return dead;
	}
}