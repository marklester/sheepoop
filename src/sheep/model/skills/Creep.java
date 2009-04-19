package sheep.model.skills;

import java.awt.event.ActionEvent;

import sheep.model.Time;
import sheep.model.TimeObserver;
import sheep.model.entities.StatType;

public class Creep extends PerformableSkill implements TimeObserver {
	private int stealthtick = 0;
	private static final long serialVersionUID = 5324312372447589727L;

	public Creep() {
		super("Creep");
	}

	// @Override
	public void actionPerformed(ActionEvent e) {
		if (getCharacter().getStat(StatType.MANA) > 5) {
			getCharacter().affectStat(StatType.STEALTH, points);
			getCharacter().affectStat(StatType.MANA_USED, 5);
			Time.getInstance().registerObserver(this);
		} else {
			getCharacter().hearMessage(getCharacter(), "Not Enough Mana to use Creep");
		}
	}

	public void tick() {
		if (stealthtick == 100) {
			stealthtick = 0;
			if (getCharacter().getStat(StatType.STEALTH) == 0) {
				Time.getInstance().removeObserver(this);
			} else {
				getCharacter().affectStat(StatType.STEALTH, -1);
			}
		} else {
			stealthtick++;
		}
	}
}