package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.view.TradeViewport;
import sheep.view.View;

public class ToggleTradeAction extends AbstractAction {

	private static final long serialVersionUID = -8715010716409447137L;
	private View view;

	public ToggleTradeAction( View view, TradeViewport tv )
	{
		this.view = view;
		view.setTradeViewport(tv);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		view.toggleTradeViewport();
	}
}
