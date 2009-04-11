package sheep.model.skills;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.entities.Character;

/**
 * 
 * @author Phil Freo
 */

public abstract class PerformableSkill extends AbstractAction {
	private static final long serialVersionUID = -8562441519176962234L;
	
	public int points;
	private final Character character;

	public PerformableSkill(Character character) {
		this.character = character;
		this.points = 0;
	}

	public void addPoints(int amt) {
		this.points += amt;
	}

	public Character getCharacter() {
		return character;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public abstract void actionPerformed(ActionEvent e);
}