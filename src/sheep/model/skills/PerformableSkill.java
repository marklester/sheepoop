package sheep.model.skills;

import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.AbstractAction;

import sheep.model.entities.Character;

/**
 * 
 * @author Phil Freo
 */
public abstract class PerformableSkill extends AbstractAction implements Serializable {
	private static final long serialVersionUID = -8562441519176962234L;
	
	public int points;
	private Character character;

	public PerformableSkill(Character character) {
		this.character = character;
		this.points = 0;
	}
	public PerformableSkill() {
		this.points = 1;
	}

	public void addPoints(int amt) {
		this.points += amt;
	}

	public Character getCharacter() {
		return character;
	}
	
	public void setCharacter(Character c) {
		this.character = c;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public abstract void actionPerformed(ActionEvent e);
}