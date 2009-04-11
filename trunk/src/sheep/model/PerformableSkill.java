package sheep.model;

import sheep.model.entities.Character;
import sheep.model.entities.Entity;

public abstract class PerformableSkill implements model.Action {
	public int points;
	model.Character unnamed_Character_;

	public PerformableSkill(model.Entity entity) {
		throw new UnsupportedOperationException();
	}

	public void addPoints(int amt) {
		throw new UnsupportedOperationException();
	}

	public abstract void actionPerformed();
}