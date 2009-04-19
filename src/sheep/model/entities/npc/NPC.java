package sheep.model.entities.npc;

import sheep.model.GameStateType;
import sheep.model.Model;
import sheep.model.Time;
import sheep.model.entities.Character;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.entities.npc.ai.AI;
import sheep.model.entities.npc.ai.AngryAI;
import sheep.model.entities.npc.ai.DumbAI;
import sheep.model.gamemap.Location;
import sheep.model.items.weapons.Weapon;
import sheep.model.occupations.Occupation;

public class NPC extends Character {

	private static final long serialVersionUID = 3556634534829274948L;

	boolean dead = false;
	private final Model model;
	private int hostility;
	private AI activeAi;
	private AI peacefulAi;
	private AI angryAi;
	
	
	public NPC(String id, Model model, Location loc, Occupation occupation, int initialHostility, AI peacefulAi, AI angryAi) {
		super(id, model, loc, occupation);
		this.model = model;
		hostility = initialHostility;
		peacefulAi.attachNPC(this);
		angryAi.attachNPC(this);
	}

	public AI getActiveAi()
	{
		return activeAi;
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

	public int getHostility() {
		return hostility;
	}
	
	public void affectHostility( int changeAmt ) {
		this.hostility = hostility + changeAmt;
		//this.hostility = ( hostility < 0 ) ? 0 : hostility;
		//this.hostility = ( hostility > 100) ? 100 : hostility;
		if(hostility > 50)
		{
			peacefulAi.detachNPC();
			angryAi.attachNPC(this);
			activeAi = angryAi;
		}
		else if (hostility <= 50)
		{
			angryAi.detachNPC();
			peacefulAi.attachNPC(this);
			activeAi = peacefulAi;
		}
		System.out.println("Hostility: " + hostility);
	}
	
	public void weaponDamage( int damage )
	{
		//(hopefully) linear hostility increase as health goes down.
		//int lifeLeft = (int) ( ( ( ( double) this.getStat( StatType.DAMAGE) + damage)  / (double) this.getStat( StatType.MAX_LIFE ) )* 100.0);
		
		//int dx = lifeLeft - this.getHostility();
		//this.affectHostility( (dx > 0) ? dx : 0  );
		
		affectHostility(damage);
		
		super.weaponDamage( damage );
	}
	
	@Override
	public void setInteractingCharacter(Character character) {
		super.setInteractingCharacter(character);
		
		// Check if we are trying to move into the avatar, and possibly attack 
		if (character == model.getAvatar()) {
			activeAi.bumpedIntoAvatar(model.getAvatar());
		}
	}

	@Override
	public void die() {
		dead = true;
		Time.getInstance().removeObserver(angryAi);
		Time.getInstance().removeObserver(peacefulAi);
		//sai.setNPC(null);
		angryAi=null;
		peacefulAi=null;
		this.getGameMap().remove(getLocation(),this);
		setLocation(null);
	}
	@Override
	public boolean isDead()
	{
		return dead;
	}
	@Override
	public void hitWith(Weapon w) {
		//System.out.println(getID()+" was hit with "+w.getID());
		w.applyEffect(this);
	}
}