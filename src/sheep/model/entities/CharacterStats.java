package sheep.model.entities;

import java.util.HashMap;

/**
 * 
 * @author Phil Freo
 */
public class CharacterStats implements Cloneable {

	private HashMap<StatType, Integer> stats = new HashMap<StatType, Integer>();

	public CharacterStats(HashMap<StatType, Integer> initialStats) {
		this.stats = initialStats;
	}

	public void change(StatType stat, int changeAmt) {
		int oldAmt = this.stats.get(stat);
		int newAmt = oldAmt + changeAmt;
		this.stats.put(stat, newAmt);
	}

	public int get(StatType stat) {
		return stats.get(stat);
	}

	public void set(StatType stat, int amt) {
		stats.put(stat, amt);
	}

	@SuppressWarnings("unchecked")
	public CharacterStats clone() {
		try {
			CharacterStats result = (CharacterStats) super.clone();
			result.stats = (HashMap<StatType, Integer>) stats.clone();
			return result;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("CharacterStats could not be cloned");
		}
	}
}