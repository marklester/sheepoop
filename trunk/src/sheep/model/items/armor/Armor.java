package sheep.model.items.armor;

import sheep.model.Model;
import sheep.model.entities.BodyPart;
import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;

public abstract class Armor extends Takeable {
	
	private int armorBonus;
	
	private static final long serialVersionUID = 6475799713135184079L;
	private BodyPart where;
	
	public Armor(String id, Model model, Location loc, BodyPart bodyLocation, int armorBonus) {
		super(id, model, loc);
		where = bodyLocation;
		this.armorBonus = armorBonus;
	}
	
	public void use(Character entity)
	{
		entity.equip(this);
	}
	public BodyPart getBodyPart() {
		return this.where;
	}
	public void equipTo(Character c)
	{
		c.affectStat(StatType.ARMOR_RATING, armorBonus);
	}
	
	public void unequipFrom(Character c)
	{
		c.affectStat(StatType.ARMOR_RATING, -armorBonus);
	}
}