package sheep.controller;

import sheep.model.entities.Avatar;
import sheep.model.entities.NPC;
import sheep.model.items.Takeable;

public class TradeFacilitator {
	private final Avatar avatar;
	private final NPC npc;

	public TradeFacilitator(Avatar avatar, NPC npc) {
		this.avatar = avatar;
		this.npc = npc;
	}

	public void buyItem(Takeable item) {
		throw new UnsupportedOperationException();
	}

	public float getItemBuyPrice(Takeable item) {
		throw new UnsupportedOperationException();
	}

	public float getItemSellPrice(Takeable item) {
		throw new UnsupportedOperationException();
	}

	public void sellItem(Takeable item) {
		throw new UnsupportedOperationException();
	}
}