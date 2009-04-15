package sheep.model.items.armor;

import sheep.model.entities.BodyPart;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.items.Takeable;
import sheep.model.entities.Character;

public abstract class Armor extends Takeable {
	
	private int armorBonus;
	
	private static final long serialVersionUID = 6475799713135184079L;
	private BodyPart where;
	
	public Armor(String id, GameMap map, Location loc, BodyPart bodyLocation, int armorBonus) {
		super("Armor", map, loc);
		where = bodyLocation;
		this.armorBonus = armorBonus;
	}
	
	public void use(Entity entity)
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