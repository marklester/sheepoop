package sheep.model.entities;

import java.io.Serializable;
import java.util.HashMap;

public class CharacterStats implements Cloneable, Serializable {

	private static final long serialVersionUID = -2031931040554030741L;

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
	
	public void calculateDerivedStatistics()
	{
		stats.put(StatType.LEVEL, stats.get(StatType.EXPERIENCE)/1000);
		if(stats.get(StatType.DAMAGE)<0)
		{
			stats.put(StatType.DAMAGE, 0);
		}
		
		int agility = stats.get(StatType.AGILITY);
		int hardiness = stats.get(StatType.HARDINESS);
		int intellect = stats.get(StatType.INTELLECT);
		int strength = stats.get(StatType.STRENGTH);
		int level = stats.get(StatType.LEVEL);
		
		int baseDefense = agility + level*3;
		stats.put(StatType.BASE_DEFENSIVE_RATING, baseDefense);
		int defenseBonus = stats.get(StatType.DEFENSIVE_BONUS);
		stats.put(StatType.DEFENSIVE_RATING, baseDefense+defenseBonus);
		stats.put(StatType.MAX_LIFE, hardiness*2+level*hardiness/5);
		stats.put(StatType.MAX_MANA, intellect*2+level*intellect/5);
		int baseOffense = strength*2+level*strength/5;
		int offenseBonus = stats.get(StatType.OFFENSIVE_BONUS);
		stats.put(StatType.BASE_OFFENSIVE_RATING, baseOffense);
		stats.put(StatType.OFFENSIVE_RATING, baseOffense+offenseBonus);
		
		
		
		//See if character is dead and take appropriate actions
		if((stats.get(StatType.DAMAGE)>0)&&(stats.get(StatType.DAMAGE)>(stats.get(StatType.MAX_LIFE))))
		{
			int oldLivesLeft = stats.get(StatType.LIVES_LEFT);
			stats.put(StatType.LIVES_LEFT, oldLivesLeft-1);
			stats.put(StatType.DAMAGE, 0);
		}
		int damage = stats.get(StatType.DAMAGE);
		int maxLife = stats.get(StatType.MAX_LIFE);
		
		stats.put(StatType.LIFE, maxLife-damage);
	}

	public int get(StatType stat) {
		Integer ret = stats.get(stat);
		if (ret == null) {
			//System.out.println("Character Stat not found");
			return 0;
		}
		return ret;
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