package sheep.view;

import java.awt.Component;
import java.util.Vector;

import javax.swing.JFrame;

import sheep.model.Model;

public class View extends JFrame {
	
	private static final long serialVersionUID = 2015429639828183235L;
	private Model model;
	Vector<Component> unnamed_Component_ = new Vector<Component>();

	public View(Model model) {
		throw new UnsupportedOperationException();
	}

	public void render() {
		throw new UnsupportedOperationException();
	}

	public void showTradeViewport() {
		throw new UnsupportedOperationException();
	}

	public TradeViewport getTradeViewport() {
		throw new UnsupportedOperationException();
	}

	public void update(Object object) {
		throw new UnsupportedOperationException();
	}
}