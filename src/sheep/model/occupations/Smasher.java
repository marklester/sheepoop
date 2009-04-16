package sheep.model.occupations;

import sheep.model.entities.StatType;
import sheep.model.skills.BindWounds;
import sheep.model.skills.Observation;
import sheep.model.skills.PassiveSkill;


public class Smasher extends Occupation {

	private static final long serialVersionUID = 4472300793301277305L;
	
	public Smasher() {
		super("Smasher");
		setInitialCharacterStat(StatType.OFFENSIVE_BONUS, 0);
		setInitialCharacterStat(StatType.DEFENSIVE_BONUS, 0);
		setInitialCharacterStat(StatType.DAMAGE, 0);
		setInitialCharacterStat(StatType.EXPERIENCE, 0);
		setInitialCharacterStat(StatType.AGILITY, 15);
		setInitialCharacterStat(StatType.HARDINESS, 25);
		setInitialCharacterStat(StatType.INTELLECT, 8);
		setInitialCharacterStat(StatType.SPEED, 85);
		setInitialCharacterStat(StatType.STRENGTH, 15);
		setInitialCharacterStat(StatType.LIVES_LEFT, 5);
		addPerformableSkill(new Observation());
		addPerformableSkill(new BindWounds());
		setInitialPassiveSkill(PassiveSkill.BARGAIN, 0);
		setInitialPassiveSkill(PassiveSkill.ONE_HANDED_WEAPON, 0);
		setInitialPassiveSkill(PassiveSkill.TWO_HANDED_WEAPON, 0);
		setInitialPassiveSkill(PassiveSkill.BRAWLING, 0);
	}
}