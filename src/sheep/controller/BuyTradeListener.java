package sheep.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import sheep.model.items.Takeable;

public class BuyTradeListener extends TradeListener {

	public BuyTradeListener( TradeFacilitator tf, Takeable item )
	{
		super( tf, item);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.getTradeFacilitator().buyItem( this.getItem() );
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton b = (JButton) e.getSource();
		b.setToolTipText( "Item: " + this.getItem().getID() + "\n Price: " + this.getTradeFacilitator().getItemBuyPrice( this.getItem() ) );
	}
}
