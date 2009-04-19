package sheep.controller;

import sheep.model.entities.Avatar;
import sheep.model.entities.Character;
import sheep.model.entities.StatType;
import sheep.model.items.Takeable;
import sheep.model.skills.PassiveSkill;

public class TradeFacilitator {
	
	private final Avatar avatar;
	private final Character npc;

	public TradeFacilitator(Avatar avatar, Character npc) {
		this.avatar = avatar;
		this.npc = npc;
	}

	public void buyItem(Takeable item) {
		int price = getItemBuyPrice(item);
		transactItem( avatar, npc, item, price);
	}

	public int getItemBuyPrice(Takeable item) {
		return (int) ( (double) item.getPrice() * ( ((double) avatar.getSkill( PassiveSkill.BARGAIN )+1) / ((double) npc.getSkill( PassiveSkill.BARGAIN )+1) ) ); 
		
	}

	public int getItemSellPrice(Takeable item) {
		return (int) ( (double) item.getPrice() * ( ((double) npc.getSkill( PassiveSkill.BARGAIN ) + 1) / ((double) avatar.getSkill( PassiveSkill.BARGAIN ) +1 ) ) );
	}

	public void sellItem(Takeable item) {
		int price = getItemSellPrice(item);
		transactItem(npc, avatar, item, price);
	}
	
	private void transactItem(Character buyer, Character seller, Takeable item, int price)
	{
		if( buyer.getStat( StatType.MONEY ) >= price) {
			buyer.affectStat( StatType.MONEY, price*-1);
			seller.affectStat(StatType.MONEY, price);
			seller.removeItem(item);
			buyer.addToInventory(item);
		}
	}
}