package sheep.model.items.weapons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sheep.model.Model;
import sheep.model.entities.Character;
import sheep.model.entities.npc.NPC;
import sheep.model.gamemap.Location;

public class SplashDamage extends Weapon implements ActionListener {
	private static final long serialVersionUID = -6972197855931649857L;
	protected int dmg;

	public SplashDamage(String id, Model model, Location loc,int dmg) {
		super(id, model, loc);
		this.dmg = dmg;
	}

	@Override
	public void actionPerformed(ActionEvent ae){}

	public void applyEffect(NPC e) {
		applyEffect((Character)e);
	}

	public void applyEffect(Character c) {
		//System.out.println(getID()+"hits "+this.dmg);
		c.weaponDamage(this.dmg);
	}
	@Override
	public int getDamageWith(){
		return getBaseDamage();
		//return getBaseDamage() * getUser().getSkill(getSkill());
	}
}