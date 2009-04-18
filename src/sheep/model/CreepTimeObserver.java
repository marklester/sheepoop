package sheep.model;

import sheep.model.entities.StatType;

/**
 * 
 * @author Phil Freo
 */
public class CreepTimeObserver implements TimeObserver{
	private int stealthtick=0;
	sheep.model.entities.Character character;
	public CreepTimeObserver(sheep.model.entities.Character c){
		character = c;
	}
	public void tick(){
		if(stealthtick==100){
			stealthtick=0;
			if(character.getStat(StatType.STEALTH)==0){
				Time.getInstance().removeObserver(this);
			}else{
				character.affectStat(StatType.STEALTH, -1);
			}
		}else{
			stealthtick++;
		}
	}
}