package sheep.model.skills;

import java.awt.event.ActionEvent;

import sheep.model.entities.StatType;

public class BindWounds extends PerformableSkill {
	
	private static final long serialVersionUID = -9062990493059890224L;
	public BindWounds(){
		super("Bind Wounds");
	}
	//@Override
	public void actionPerformed(ActionEvent e) {
		if(getCharacter().getStat(StatType.MANA)>=5){
			getCharacter().affectStat(StatType.DAMAGE, (int)(-Math.random()*5*getPoints()));
			getCharacter().affectStat(StatType.MANA_USED, 5);
		}
	}

}