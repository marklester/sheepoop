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
		double npcBarg = npc.getSkill( PassiveSkill.BARGAIN );
		double avBarg = avatar.getSkill( PassiveSkill.BARGAIN );
		double price = item.getPrice();
		
		return (int) ( price + (price * ( ( npcBarg - avBarg ) / 100.0 ) ) );
	}

	public int getItemSellPrice(Takeable item) {
		double npcBarg = npc.getSkill( PassiveSkill.BARGAIN );
		double avBarg = avatar.getSkill( PassiveSkill.BARGAIN );
		double price = item.getPrice();
		
		return (int) ( price + (price * ( ( avBarg - npcBarg ) / 100.0 ) ) );
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