package sheep.model.items.weapons;

import java.awt.event.ActionEvent;
import java.util.List;

import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.util.math.Vector2D;

public class CrossBow extends LongRange {

	private static final long serialVersionUID = -6449910210910592975L;
	
	public CrossBow(GameMap map, Location loc) {
		super("Crossbow", map, loc, 15);
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
			Projectile myProj = new Projectile("xbowbolt",getGameMap(),attackingTile,this,getUser().getFacingDirection(),5);
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