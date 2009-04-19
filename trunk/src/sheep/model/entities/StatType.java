package sheep.model.entities;

import java.io.Serializable;

/**
 * 
 * @author Phil Freo
 */
public enum StatType implements Serializable {
	SPEED ("Speed"), 
	LIVES_LEFT("Lives Left"), 
	STRENGTH("Strength"), 
	AGILITY("Agility"), 
	INTELLECT("Intellect"), 
	HARDINESS("Hardiness"), 
	EXPERIENCE("Experience"),
	DAMAGE("Damage"),
	MANA_USED("Mana Used"),
	OFFENSIVE_BONUS("OBonus"),
	DEFENSIVE_BONUS("DBonus"),
	//Derived stats below
	LEVEL("Level"), 
	LIFE("Life"),
	STEALTH("Stealth"),
	MANA("Mana"), 
	BASE_OFFENSIVE_RATING("Base Offensive Rating"), 
	OFFENSIVE_RATING("Offesive Rating"), 
	BASE_DEFENSIVE_RATING("Base Defensive Rating"), 
	DEFENSIVE_RATING("Defensive Rating"), 
	ARMOR_RATING("Armor Rating"), 
	MAX_MANA("Max Mana"),
	MONEY("Money"),
	MAX_LIFE("Max Life"),
	SKILL_POINTS_TO_GIVE("Skill Points");
	String name;
	StatType(String name){
		this.name=name;
	}
	public static StatType random(){
		int random = (int)(Math.random()*(StatType.values().length-1));
		return StatType.values()[random];
	}
}