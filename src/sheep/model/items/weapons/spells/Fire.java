package sheep.model.items.weapons.spells;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.model.items.Trap;
import sheep.model.items.weapons.Projectile;
import sheep.model.skills.PassiveSkill;
import sheep.util.math.Vector2D;

public class Fire extends Bane {

	private static final long serialVersionUID = 2866354681809705242L;
	
	public Fire(Model model, Location loc) {
		super("Fire", model, loc, 20, 5);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Character enemy = getUser().getInteractingCharacter();
		
		if( enemy != null ){
			int totalDamage = (int) Math.floor( (double) getBaseDamage() * (  (double) getUser().getSkill( getSkill() ) ) );
			
			enemy.affectStat( StatType.LIFE, totalDamage );
		}
		else{
			Location center = getUser().getLocation();
			Map<Location, List<Locatable>> tiles = getUser().getGameMap().getMapSubset(center, 1);
			for (Entry<Location, List<Locatable>> entry : tiles.entrySet()) {
				Location loc = entry.getKey();
				Projectile myProj = new Projectile(getProjectileId(),this.getModel(),loc,this,center.relativeDirectionTo(loc),5,2);
				List<Locatable> targets = entry.getValue();
				boolean blocked = false;
				for(Locatable l: targets){
					l.hitWith(this);
					if(l.blocks(myProj)){
						blocked = true;
					}
				}
				if(!blocked){
					getGameMap().add(loc, myProj);
				}
			}
			
		}
	}
}