package sheep.model.entities;

import java.util.Map;

public class CharacterStats implements Cloneable {
	
	public Map<StatType, Integer> stats;

	public CharacterStats(Map<StatType, Integer> initialStats) {
		throw new UnsupportedOperationException();
	}

	public void change(StatType stat, int changeAmt) {
		throw new UnsupportedOperationException();
	}

	public int get(StatType stat) {
		throw new UnsupportedOperationException();
	}

	public void set(StatType stat, int amt) {
		throw new UnsupportedOperationException();
	}
	
	public CharacterStats clone() {
		throw new UnsupportedOperationException();
	}
}