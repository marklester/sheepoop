package sheep.model.skills;

import java.awt.event.ActionEvent;

import sheep.model.entities.Character;
import sheep.model.entities.StatType;

public class BindWounds extends PerformableSkill {
	
	private static final long serialVersionUID = -9062990493059890224L;

	public BindWounds(Character character) {
		super(character);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getCharacter().affectStat(StatType.DAMAGE, (int)-Math.random()*5*getPoints());
	}

}