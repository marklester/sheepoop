package sheep.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sheep.model.Model;

/**
 * The main window during game play
 * @author Phil Freo
 */
public class View extends JFrame {

	private static final long serialVersionUID = 2015429639828183235L;
	public static final int SIDE_BAR_W = 300;
	private static final boolean FULL_SCREEN_MODE = true;
	private final Model model;
	private TradeViewport tradeViewport;
	private AreaViewport areaViewport;
	private InventoryViewport invViewport;
	private JPanel sidebar;
	private int areaViewportWidth; 
	

	public View(Model model) {
		this.model = model;
		setUpFrame();
		
		//Initialize Viewports
		invViewport = new InventoryViewport(model.getAvatar(), SIDE_BAR_W, this.getHeight());
		tradeViewport = new TradeViewport(model.getAvatar(), null, SIDE_BAR_W, this.getHeight());
		showInventoryViewport();
	}
	
	/**
	 * Setup the dimensions of the JFame and the 2 JPanels, AreaViewport 
	 * and the side bar panel. It then proceeds to create both JPanels and
	 * set their properties (opacity, bg, etc.)
	 */

	private void setUpFrame() {
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = ge.getDefaultScreenDevice();
		areaViewportWidth = (int) ge.getMaximumWindowBounds().getWidth() - SIDE_BAR_W;

		this.setTitle("Sheepoop");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create area viewport
		areaViewport = new AreaViewport(this.model.getAvatar(), this.model.getGameMap());
		areaViewport.setOpaque(true);
		areaViewport.setBackground(Color.BLACK);
		this.getContentPane().add(areaViewport, BorderLayout.CENTER);
//		JPanel test = new JPanel();
//		test.setPreferredSize(new Dimension(areaViewportWidth, this.getHeight()));
//		test.setBackground(Color.orange);
//		this.getContentPane().add(test, BorderLayout.WEST);
		
		// Create sidebar
		sidebar = new JPanel();
		sidebar.setOpaque(true);
		sidebar.setBackground(Color.WHITE);
		sidebar.setSize(new Dimension(SIDE_BAR_W, this.getHeight()));
		this.getContentPane().add(sidebar, BorderLayout.EAST);
		
		// Set full screen
		if (device.isFullScreenSupported() && FULL_SCREEN_MODE) {
			setUndecorated(true);
			setResizable(false);
			device.setFullScreenWindow(this);
			validate();
		} else {
			this.setExtendedState(Frame.MAXIMIZED_BOTH); 
			this.setVisible(true);
		}

		// Tell viewports they can DO THEIR THANG
		areaViewport.initialize();
	}

	public void render() {
		throw new UnsupportedOperationException();
	}

	public void showTradeViewport() {
		this.invalidate();
		this.remove(sidebar);
		this.sidebar = tradeViewport;
		this.getContentPane().add(sidebar, BorderLayout.EAST);
		this.validate();
		sidebar.setVisible(true);
	}

	public TradeViewport getTradeViewport() {
		return tradeViewport;
	}
	
	public void toggleTradeViewport() {
		tradeViewport.setVisible(!tradeViewport.isVisible());
	}
	
	public void showInventoryViewport() {
		this.invalidate();
		this.remove(sidebar);
		this.sidebar = invViewport;
		this.getContentPane().add(sidebar, BorderLayout.EAST);
		this.validate();
		sidebar.setVisible(true);
	}
	
	public void toggleInventoryViewport() {
		invViewport.setVisible(!invViewport.isVisible());
	}
	
	public AreaViewport getAreaViewport() {
		return areaViewport;
	}
	
	public InventoryViewport getInventoryViewport() {
		return this.invViewport;
	}

}
