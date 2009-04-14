package sheep.model.occupations;

import java.util.ArrayList;
import java.util.HashMap;

import sheep.model.entities.CharacterStats;
import sheep.model.entities.StatType;
import sheep.model.skills.BindWounds;
import sheep.model.skills.Observation;
import sheep.model.skills.PassiveSkill;
import sheep.model.skills.PerformableSkill;
import sheep.model.entities.Character;


public class Smasher extends Occupation {

	private static final long serialVersionUID = 4472300793301277305L;

	static CharacterStats myCS = new CharacterStats(new HashMap<StatType, Integer>());
	static ArrayList<PerformableSkill> myPerformables;
	static HashMap<PassiveSkill,Integer> myPassives;
	
	public Smasher(Character c) {
		super("Smasher", myCS, myPerformables, myPassives);
		myCS.set(StatType.AGILITY, 15);
		myCS.set(StatType.HARDINESS, 25);
		myCS.set(StatType.INTELLECT, 8);
		myCS.set(StatType.SPEED, 15);
		myCS.set(StatType.STRENGTH, 15);
		myPerformables = new ArrayList<PerformableSkill>();
		myPerformables.add(new BindWounds(c));
		myPerformables.add(new Observation(c));
		myPassives = new HashMap<PassiveSkill,Integer>();
	}
}