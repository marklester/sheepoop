package sheep.model.items.weapons.spells;

import java.awt.event.ActionEvent;
import java.util.List;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.model.items.weapons.Projectile;
import sheep.model.items.weapons.Weapon;
import sheep.model.skills.PassiveSkill;
import sheep.util.math.Vector2D;

public abstract class Spell extends Weapon {
	
	int mySpeed;

	private static final long serialVersionUID = -1606083256607931219L;
	
	public Spell(String id, Model model, Location loc, int baseDamage, PassiveSkill skill, int speed) {
		super(id, model, loc, baseDamage, skill);
		mySpeed = speed;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Character enemy = getUser().getInteractingCharacter();
		
		if( enemy != null )
		{
			int totalDamage = (int) Math.floor( (double) getBaseDamage() * (  (double) getUser().getSkill( getSkill() ) ) );
			
			enemy.affectStat( StatType.LIFE, totalDamage );
		}
		else
		{
			Vector2D myVector = getUser().getFacingDirection().getVector(getLocation());
			Location attackingTile = new Location(getLocation().getX()+(int)myVector.getX(),getLocation().getY()+(int)myVector.getY());
			List<Locatable> targets = getGameMap().get(attackingTile);
			boolean blocked = false;
			Projectile myProj = new Projectile(getID(),getGameMap(),attackingTile,this,getUser().getFacingDirection(),mySpeed);
			for(Locatable l: targets)
			{
				l.hitWith(this);
				if(l.blocks(myProj))
				{
					blocked = true;
				}
			}
			if(!blocked)
			{
				getGameMap().add(attackingTile, myProj);
			}
		}
	}
}