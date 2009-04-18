package sheep.model.items;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.entities.StatType;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;

public class Trap extends Interactive{
	private static final long serialVersionUID = -2451877763558545713L;
	private int dmgAmt;

	private boolean activated=false;
	public Trap(Model model, Location loc,int dmg_amt) {
		super("Hidden Trap", model, loc);
		this.dmgAmt = dmg_amt;
	}

	public void touch(Entity entity){
		if(!activated && entity.equals(getModel().getMover())){
			sheep.model.entities.Character ce = (sheep.model.entities.Character)entity;
			ce.affectStat(StatType.DAMAGE, dmgAmt);
			deActivate();
		}
	}
	public void showTrap(){
		setId("Detected Trap");
	}
	public void deActivate(){
		activated = true;
		this.setId("Activated Trap");
	}
	public boolean blocks(Entity entity) {
		return false;
	}
	public int getDmgAmt() {
		return dmgAmt;
	}

	public void setDmgAmt(int dmgAmt) {
		this.dmgAmt = dmgAmt;
	}
}