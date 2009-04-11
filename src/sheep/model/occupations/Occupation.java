package sheep.model.occupations;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import sheep.model.entities.CharacterStats;
import sheep.model.skills.PassiveSkill;
import sheep.model.skills.PerformableSkill;

/**
 * 
 * @author Phil Freo
 */
public abstract class Occupation implements Serializable {
	
	private static final long serialVersionUID = -1843039758287359854L;
	public final CharacterStats initialStats;
	public final Vector<PerformableSkill> performableSkills;
	public final HashMap<PassiveSkill, Integer> passiveSkills;
	private final String id;

	public Occupation(String id, CharacterStats initialStats, List<PerformableSkill> performableSkills, Map<PassiveSkill, Integer> passiveSkills) {
		this.id = id;
		this.performableSkills = (Vector<PerformableSkill>) performableSkills;
		this.initialStats = initialStats;
		this.passiveSkills = (HashMap<PassiveSkill, Integer>) passiveSkills;
	}

	public CharacterStats cloneStats() {
		return this.initialStats.clone();
	}

	@SuppressWarnings("unchecked")
	public Map<PassiveSkill, Integer> clonePassiveSkills() {
		return (Map<PassiveSkill, Integer>) this.passiveSkills.clone();
	}

	@SuppressWarnings("unchecked")
	public List<PerformableSkill> clonePerformableSkills() {
		return (List<PerformableSkill>) this.performableSkills.clone();
	}

	public String getID() {
		return this.id;
	}
}