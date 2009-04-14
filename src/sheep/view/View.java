package sheep.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sheep.model.Model;

public class View extends JFrame {

	private static final long serialVersionUID = 2015429639828183235L;
	private Model model;
	private TradeViewport tradeViewport;
	private static final boolean FULL_SCREEN_MODE = true;

	public View(Model model) {
		this.model = model;

		setUpFrame();
	}

	private void setUpFrame() {

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = ge.getDefaultScreenDevice();

		this.setTitle("Sheepoop");
		
		// Create area viewport
		JPanel areaViewport = new JPanel();
		areaViewport.setOpaque(true);
		areaViewport.setBackground(Color.BLACK);
		this.getContentPane().add(areaViewport, BorderLayout.CENTER);
		
		// Create sidebar
		JPanel sidebar = new JPanel();
		sidebar.setOpaque(true);
		sidebar.setBackground(Color.WHITE);
		sidebar.setPreferredSize(new Dimension(400, 1));
		this.getContentPane().add(sidebar, BorderLayout.EAST);
		
		
		if (device.isFullScreenSupported() && FULL_SCREEN_MODE) {
			setUndecorated(true);
			setResizable(false);
			device.setFullScreenWindow(this);
			validate();
		} else {
			this.setExtendedState(Frame.MAXIMIZED_BOTH); 
			this.setVisible(true);
		}

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
