package sheep.model.entities;

import java.io.Serializable;
import java.util.HashMap;

public class CharacterStats implements Cloneable, Serializable {

	private static final long serialVersionUID = -2031931040554030741L;
	private static final int pointsPerLevelUp = 5; 
	private Character character;
	private HashMap<StatType, Integer> stats = new HashMap<StatType, Integer>();

	public CharacterStats(HashMap<StatType, Integer> initialStats) {
		this.stats = initialStats;
	}
	
	public void change(StatType stat, int changeAmt) {
		int oldAmt = get(stat);
		int newAmt = oldAmt + changeAmt;
		this.stats.put(stat, newAmt);
		calculateDerivedStatistics();
	}
	
	public void setCharacter(Character character) {
		this.character = character;
	}

	public void calculateDerivedStatistics() {
		int currLevel = get(StatType.LEVEL);
		stats.put(StatType.LEVEL, get(StatType.EXPERIENCE) / 1000 + 1);
		//Give points for a level up
		if (get(StatType.LEVEL) > currLevel) {
			int currPoints = get(StatType.SKILL_POINTS_TO_GIVE);
			set(StatType.SKILL_POINTS_TO_GIVE, pointsPerLevelUp + currPoints);
		}
		if (get(StatType.DAMAGE) < 0) {
			stats.put(StatType.DAMAGE, 0);
		}

		int agility = get(StatType.AGILITY);
		int hardiness = get(StatType.HARDINESS);
		int intellect = get(StatType.INTELLECT);
		int strength = get(StatType.STRENGTH);
		int level = get(StatType.LEVEL);

		int baseDefense = agility + level * 3;
		stats.put(StatType.BASE_DEFENSIVE_RATING, baseDefense);
		int defenseBonus = get(StatType.DEFENSIVE_BONUS);
		stats.put(StatType.DEFENSIVE_RATING, baseDefense + defenseBonus);
		stats.put(StatType.MAX_LIFE, hardiness * 2 + level * hardiness / 5);
		
		int maxMana = intellect * 2 + level * intellect / 5;
		stats.put(StatType.MAX_MANA, maxMana);
		int manaUsed = get(StatType.MANA_USED);
		if(manaUsed > maxMana)
		{
			manaUsed = maxMana;
			stats.put(StatType.MANA_USED, manaUsed);
		}
		else if(manaUsed < 0)
		{
			manaUsed = 0;
			stats.put(StatType.MANA_USED, 0);
		}
		stats.put(StatType.MANA, maxMana - get(StatType.MANA_USED));
//		int baseOffense = strength * 2 + level * strength / 5;
//		int offenseBonus = get(StatType.OFFENSIVE_BONUS);
//		stats.put(StatType.BASE_OFFENSIVE_RATING, baseOffense);
//		stats.put(StatType.OFFENSIVE_RATING, baseOffense + offenseBonus);

		// See if character is dead and take appropriate actions
		if ((get(StatType.DAMAGE) > 0) && (get(StatType.DAMAGE) > (get(StatType.MAX_LIFE)))) {
			int oldLivesLeft = get(StatType.LIVES_LEFT);
			stats.put(StatType.LIVES_LEFT, oldLivesLeft - 1);
			stats.put(StatType.DAMAGE, 0);
			character.die();
		}
		int damage = get(StatType.DAMAGE);
		int maxLife = get(StatType.MAX_LIFE);

		stats.put(StatType.LIFE, maxLife - damage);
	}

	public int get(StatType stat) {
		if(stat == StatType.OFFENSIVE_RATING)
			return character.getDamageWithWeapon();
		Integer ret = stats.get(stat);
		if (ret == null) {
			// System.out.println("Character Stat not found");
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