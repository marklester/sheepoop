package sheep.model.skills;

import java.awt.event.ActionEvent;

import sheep.model.Time;
import sheep.model.entities.StatType;

public class Creep extends PerformableSkill {

	private static final long serialVersionUID = 5324312372447589727L;
	public Creep(){
		super("Creep");
	}
	//@Override
	public void actionPerformed(ActionEvent e) {
		if(getCharacter().getStat(StatType.MANA)>5){
			getCharacter().affectStat(StatType.STEALTH, points);
			getCharacter().affectStat(StatType.MANA_USED, 5);
			Time.getInstance().registerObserver(getCharacter().getCreeptimer());
		}else{
			getCharacter().hearMessage(getCharacter(), "Not Enough Mana to use Creep");
		}
	}


}