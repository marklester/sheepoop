package sheep.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sheep.model.items.Takeable;

public class BuyTradeListener implements ActionListener {

	private TradeFacilitator tf;
	private Takeable item;
	private JPanel info;
	
	public BuyTradeListener( TradeFacilitator tf, Takeable item )
	{
		this.item = item;
		this.tf = tf;
		
		info = new JPanel();
		info.setLayout( new BoxLayout( info, BoxLayout.Y_AXIS ) );
		info.add( new JLabel( "Name: " + item.getID() ) );
		info.add( new JLabel("Price: " + tf.getItemBuyPrice(item)) );
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("buy click");
		tf.buyItem( item );
	}

}
