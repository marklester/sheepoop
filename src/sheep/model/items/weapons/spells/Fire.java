package sheep.model.items.weapons.spells;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.entities.npc.NPC;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.model.items.weapons.Projectile;
import sheep.model.items.weapons.SplashDamage;

public class Fire extends Bane {

	private static final long serialVersionUID = 2866354681809705242L;

	public Fire(Model model, Location loc) {
		super("Fire", model, loc, 20, 5, 100);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//System.out.println("Fire");
		if (this.getUser().getStat(StatType.MANA) < 20) {
		} else {
			Location center = getUser().getLocation();
			Map<Location, List<Locatable>> tiles = getUser().getGameMap().getMapSubset(center, 1);
			for (Entry<Location, List<Locatable>> entry : tiles.entrySet()) {
				Location loc = entry.getKey();
				Projectile myProj = new Projectile(getProjectileId(), this.getModel(), loc, this, center
						.relativeDirectionTo(loc), 5, 2);
				List<Locatable> targets = entry.getValue();
				boolean blocked = false;
				for (Locatable l : targets) {
					if (l.blocks(myProj)) {
						blocked = true;
						if (getUser() != l) {
							l.hitWith(this);
						}
					}
				}
				if (!blocked) {
					getGameMap().add(loc, myProj);
				}

			}
			this.getUser().affectStat(StatType.MANA_USED, 10);
		}
	}
	public void applyEffect(NPC c){
		applyEffect((Character)c);
	}
	public void applyEffect(Character c){
		//System.out.println(getID()+"hits "+this.getDamageWith());
		int realdmg = getDamageWith();
		Map<Location, List<Locatable>> tiles = c.getGameMap().getMapSubset(c.getLocation(), 1);
		c.weaponDamage(realdmg);
		for (Entry<Location, List<Locatable>> entry : tiles.entrySet()) {
			List<Locatable> targets = entry.getValue();
			//System.out.println(entry.getKey());
			int splash_dmg = realdmg / 2;
			for (Locatable l : targets) {
				l.hitWith(new SplashDamage("Splash Damage", this.getModel(), this.getLocation(), splash_dmg));
			}
		}
	}
	@Override
	public int getDamageWith()
	{
		return getBaseDamage() * getUser().getSkill(getSkill());
	}
}