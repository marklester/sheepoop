package sheep.view;

import javax.swing.JFrame;

import sheep.model.Model;

public class View extends JFrame {
	
	private static final long serialVersionUID = 2015429639828183235L;
	private Model model;
	private TradeViewport tradeViewport;

	public View(Model model) {
		this.model = model;
		this.setVisible(true);
	}

	public void render() {
		throw new UnsupportedOperationException();
	}

	public void showTradeViewport() {
		tradeViewport.setVisible(true);
	}

	public TradeViewport getTradeViewport() {
		throw new UnsupportedOperationException();
	}

}