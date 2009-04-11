package sheep.model.occupations;

import java.util.List;
import java.util.Map;

import sheep.model.entities.CharacterStats;
import sheep.model.skills.PassiveSkill;
import sheep.model.skills.PerformableSkill;

public abstract class Occupation {
	public CharacterStats initialStats;
	public List<PerformableSkill> skills;
	private String id;

	public Occupation(String id, CharacterStats initialStats, List<PerformableSkill> performableSkills, Map<PassiveSkill, Integer> passiveSkills) {
		throw new UnsupportedOperationException();
	}

	public CharacterStats cloneStats() {
		throw new UnsupportedOperationException();
	}

	public Map<PassiveSkill, Integer> clonePassiveSkills() {
		throw new UnsupportedOperationException();
	}

	public List<PerformableSkill> cloneUseableSkills() {
		throw new UnsupportedOperationException();
	}

	public String getID() {
		throw new UnsupportedOperationException();
	}
}