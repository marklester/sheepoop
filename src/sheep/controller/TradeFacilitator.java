package sheep.controller;

import sheep.model.entities.Avatar;
import sheep.model.entities.npc.NPC;
import sheep.model.items.Takeable;
import sheep.model.skills.PassiveSkill;

public class TradeFacilitator {
	
	private final Avatar avatar;
	private final NPC npc;

	public TradeFacilitator(Avatar avatar, NPC npc) {
		this.avatar = avatar;
		this.npc = npc;
	}

	public void buyItem(Takeable item) {
		
	}

	public int getItemBuyPrice(Takeable item) {
		return (int) ( (double) item.getPrice() * ( (double) avatar.getSkill( PassiveSkill.BARGAIN ) / (double) npc.getSkill( PassiveSkill.BARGAIN ) ) ); 
		
	}

	public int getItemSellPrice(Takeable item) {
		return 0;
	}

	public void sellItem(Takeable item) {
	}
}