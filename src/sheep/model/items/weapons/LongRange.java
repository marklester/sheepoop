package sheep.model.items.weapons;

import java.awt.event.ActionEvent;
import java.util.List;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.model.skills.PassiveSkill;
import sheep.util.math.Vector2D;

public abstract class LongRange extends Weapon {

	String projectileId;
	private static final long serialVersionUID = 6552089684638959608L;
	
	public LongRange(String projId, String id, Model model, Location loc, int baseDamage) {
		super(id, model, loc, baseDamage, PassiveSkill.RANGED_WEAPON);
		projectileId = projId;
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
			Location userLoc = getUser().getLocation();
			Vector2D myVector = getUser().getFacingDirection().getVector(userLoc);
			Location attackingTile = new Location(userLoc.getX()+(int)myVector.getX(),userLoc.getY()+(int)myVector.getY());
			List<Locatable> targets = getGameMap().get(attackingTile);
			boolean blocked = false;
			Projectile myProj = new Projectile(projectileId,this.getModel(),attackingTile,this,getUser().getFacingDirection(),5);
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