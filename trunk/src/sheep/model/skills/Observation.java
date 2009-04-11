package sheep.model.skills;

import java.awt.event.ActionEvent;

import sheep.model.entities.Character;

public class Observation extends PerformableSkill {

	private static final long serialVersionUID = 8591691388338199436L;

	public Observation(Character character) {
		super(character);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}