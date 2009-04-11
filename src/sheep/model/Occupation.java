package sheep.model;

public abstract class Occupation {
	public model.CharacterStats initialStats;
	public List<Skill> skills;
	private String id;

	public Occupation(String id, model.CharacterStats initialStats, List<Skill> performableSkills, Map<model.PassiveSkill, int> passiveSkills) {
		throw new UnsupportedOperationException();
	}

	public model.CharacterStats cloneStats() {
		throw new UnsupportedOperationException();
	}

	public Map<model.PassiveSkill, int> clonePassiveSkills() {
		throw new UnsupportedOperationException();
	}

	public List<model.PerformableSkill> cloneUseableSkills() {
		throw new UnsupportedOperationException();
	}

	public String getID() {
		throw new UnsupportedOperationException();
	}
}