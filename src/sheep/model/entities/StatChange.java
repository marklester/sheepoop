package sheep.model.entities;

import java.io.Serializable;

/**
 * 
 * @author Phil Freo
 */
public class StatChange implements Serializable {

	private static final long serialVersionUID = -2271788360212648314L;
	
	private final StatType statType;
	private final int changeAmt;
	
	public StatChange(StatType statType, int changeAmt) {
		this.statType = statType;
		this.changeAmt = changeAmt;
	}

	public StatType getStatType() {
		return this.statType;
	}

	public int getChangeAmount() {
		return this.changeAmt;
	}
}