package sheep.model.entities;

import sheep.model.ObservationType;

public class StatChange implements ObservationType {

	public StatChange(StatType statType) {
		throw new UnsupportedOperationException();
	}

	public StatType getStatType() {
		throw new UnsupportedOperationException();
	}

	public int getChangeAmount() {
		throw new UnsupportedOperationException();
	}
}