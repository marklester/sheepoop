package sheep.model.occupations;

import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.skills.BindWounds;
import sheep.model.skills.Creep;
import sheep.model.skills.Observation;
import sheep.model.skills.PassiveSkill;
import sheep.model.skills.PickPocket;
import sheep.model.skills.RemoveTrap;

public class Sneak extends Occupation {
	
	private static final long serialVersionUID = 8671860996265254633L;

	public Sneak(Character c) {
		super("Sneak");
		setInitialCharacterStat(StatType.AGILITY, 25);
		setInitialCharacterStat(StatType.HARDINESS, 12);
		setInitialCharacterStat(StatType.INTELLECT, 18);
		setInitialCharacterStat(StatType.SPEED, 20);
		setInitialCharacterStat(StatType.STRENGTH, 12);
		setInitialCharacterStat(StatType.LIVES_LEFT, 5);
		addPerformableSkill(new Observation(c));
		addPerformableSkill(new BindWounds(c));
		addPerformableSkill(new Creep(c));
		addPerformableSkill(new PickPocket(c));
		addPerformableSkill(new RemoveTrap(c));
		setInitialPassiveSkill(PassiveSkill.BARGAIN, 0);
		setInitialPassiveSkill(PassiveSkill.DETECT_TRAP, 0);
		setInitialPassiveSkill(PassiveSkill.RANGED_WEAPON, 0);
	}
	
}