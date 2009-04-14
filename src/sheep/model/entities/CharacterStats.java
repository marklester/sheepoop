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
		calculateDerivedStatistics();
	}
	
	private void calculateDerivedStatistics()
	{
		stats.put(StatType.LEVEL, stats.get(StatType.EXPERIENCE)/1000);
		stats.put(StatType.BASE_DEFENSIVE_RATING, stats.get(StatType.AGILITY)+stats.get(StatType.LEVEL)*3);
		stats.put(StatType.MAX_LIFE, stats.get(StatType.HARDINESS)*2+stats.get(StatType.LEVEL)*stats.get(StatType.HARDINESS)/5);
		stats.put(StatType.MAX_MANA, stats.get(StatType.INTELLECT)*2+stats.get(StatType.LEVEL)*stats.get(StatType.INTELLECT)/5);
		stats.put(StatType.BASE_OFFENSIVE_RATING, stats.get(StatType.STRENGTH)*2+stats.get(StatType.LEVEL)*stats.get(StatType.STRENGTH)/5);
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