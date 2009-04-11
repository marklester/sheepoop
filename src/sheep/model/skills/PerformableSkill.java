package sheep.model.skills;

import javax.swing.Action;

import sheep.model.entities.Character;
import sheep.model.entities.Entity;

public abstract class PerformableSkill implements Action {
	public int points;
	Character character;

	public PerformableSkill(Entity entity) {
		throw new UnsupportedOperationException();
	}

	public void addPoints(int amt) {
		throw new UnsupportedOperationException();
	}

	public abstract void actionPerformed();
}