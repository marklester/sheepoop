package sheep.model.occupations;

import sheep.model.entities.StatType;
import sheep.model.skills.BindWounds;
import sheep.model.skills.Observation;
import sheep.model.skills.PassiveSkill;

public class Summoner extends Occupation {
	
	private static final long serialVersionUID = -7063196676299952873L;

	public Summoner() {
		super("Summoner");
		setInitialCharacterStat(StatType.DAMAGE, 0);
//		setInitialCharacterStat(StatType.OFFENSIVE_BONUS, 0);
		setInitialCharacterStat(StatType.ARMOR_RATING, 15);
		setInitialCharacterStat(StatType.DEFENSIVE_BONUS, 0);
		setInitialCharacterStat(StatType.EXPERIENCE, 0);
		setInitialCharacterStat(StatType.AGILITY, 10);
		setInitialCharacterStat(StatType.HARDINESS, 10);
		setInitialCharacterStat(StatType.INTELLECT, 30);
		setInitialCharacterStat(StatType.SPEED, 20);
		setInitialCharacterStat(StatType.STRENGTH, 10);
		setInitialCharacterStat(StatType.LIVES_LEFT, 5);
		addPerformableSkill(new Observation());
		addPerformableSkill(new BindWounds());
		setInitialPassiveSkill(PassiveSkill.BARGAIN, 0);
		setInitialPassiveSkill(PassiveSkill.BANE, 0);
		setInitialPassiveSkill(PassiveSkill.BOON, 0);
		setInitialPassiveSkill(PassiveSkill.ENCHANTMENT, 0);
		setInitialPassiveSkill(PassiveSkill.STAFF, 0);
	}
}