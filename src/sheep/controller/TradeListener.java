package sheep.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sheep.model.items.Takeable;

public abstract class TradeListener implements MouseListener, ActionListener {

	private TradeFacilitator tf;
	private Takeable item;
	
	public TradeListener( TradeFacilitator tf, Takeable item )
	{
		this.item = item;
		this.tf = tf;
	}
	
	public TradeFacilitator getTradeFacilitator()
	{
		return this.tf;
	}
	
	public Takeable getItem()
	{
		return this.item;
	}
	
	public void mouseClicked(MouseEvent e) { }

	@Override
	public abstract void mouseEntered(MouseEvent e);

	@Override
	public void mouseExited(MouseEvent e) {};

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	abstract public void actionPerformed(ActionEvent e);

}
