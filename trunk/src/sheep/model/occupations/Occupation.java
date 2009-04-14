package sheep.model.occupations;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import sheep.model.entities.CharacterStats;
import sheep.model.entities.StatType;
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

	public Occupation(String id) {
		this.id = id;
		this.performableSkills = new Vector<PerformableSkill>();
		this.initialStats = new CharacterStats(new HashMap<StatType,Integer>());
		this.passiveSkills = new HashMap<PassiveSkill, Integer>();
	}

	public CharacterStats cloneStats() {
		return this.initialStats.clone();
	}
	
	protected void setInitialCharacterStat(StatType type, int value)
	{
		initialStats.set(type, value);
	}
	
	protected void addPerformableSkill(PerformableSkill p)
	{
		performableSkills.add(p);
	}
	
	protected void setInitialPassiveSkill(PassiveSkill p, int value)
	{
		passiveSkills.put(p, value);
	}

	@SuppressWarnings("unchecked")
	public Map<PassiveSkill, Integer> clonePassiveSkills() {
		return (Map<PassiveSkill, Integer>) this.passiveSkills.clone();
	}

	@SuppressWarnings("unchecked")
	public Vector<PerformableSkill> clonePerformableSkills() {
		return (Vector<PerformableSkill>) this.performableSkills.clone();
	}

	public String getID() {
		return this.id;
	}
}