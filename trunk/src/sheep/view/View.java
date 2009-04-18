package sheep.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sheep.model.Model;

/**
 * The main window during game play
 * @author Phil Freo
 */
public class View extends JFrame {

	private static final long serialVersionUID = 2015429639828183235L;
	private static final boolean FULL_SCREEN_MODE = true;
	private static final int SIDE_BAR_W = 300;
	private final Model model;
	private SkillPointViewport skillPointViewport;
	private AreaViewport areaViewport;
	private InventoryViewport invViewport;
	private JPanel sidebar;
	private boolean gameOver = false; 

	public View(Model model) {
		this.model = model;
		setUpFrame();
		
		//Initialize Viewports
		invViewport = new InventoryViewport(model.getAvatar(), SIDE_BAR_W, this.getHeight());
		skillPointViewport = new SkillPointViewport(model.getAvatar(), SIDE_BAR_W, this.getHeight());
		showViewport(invViewport);
	}
	
	/**
	 * Setup the dimensions of the JFame and the 2 JPanels, AreaViewport 
	 * and the side bar panel. It then proceeds to create both JPanels and
	 * set their properties (opacity, bg, etc.)
	 */

	private void setUpFrame() {
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = ge.getDefaultScreenDevice();

		this.setTitle("Sheepoop");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set full screen
		if (device.isFullScreenSupported() && FULL_SCREEN_MODE) {
			setUndecorated(true);
			device.setFullScreenWindow(this);
		} else {
			//this.setVisible(true);
			//this.setExtendedState(Frame.MAXIMIZED_BOTH);
			setSize(Toolkit.getDefaultToolkit().getScreenSize());
		}
		this.setResizable(false);
		
		// Create area viewport
		areaViewport = new AreaViewport(this.model, this.model.getGameMap());
		areaViewport.setOpaque(true);
		areaViewport.setBackground(Color.BLACK);
		areaViewport.setSize(this.getWidth() - SIDE_BAR_W, this.getHeight());
		this.getContentPane().add(areaViewport, BorderLayout.CENTER);
		
		// Create sidebar placeholder
		sidebar = new Viewport(model.getAvatar());
		sidebar.setOpaque(true);
		sidebar.setSize(new Dimension(SIDE_BAR_W, this.getHeight()));
		this.getContentPane().add(sidebar, BorderLayout.EAST);

		// Tell viewports they can DO THEIR THANG
		areaViewport.initialize();
		
		// Show window
		areaViewport.setFocusable(true);
		validate();
		this.setVisible(true);
	}

	public void showViewport(Viewport theViewP) {
		this.invalidate();
		this.remove(sidebar);
		((Viewport)sidebar).toggleVisibility(); //sorta ghetto, sorry.
		this.sidebar = theViewP;
		this.getContentPane().add(sidebar, BorderLayout.EAST);
		this.validate();
		sidebar.setVisible(true);
		theViewP.toggleVisibility();
	}

//	public void showInventoryViewport() {
//		this.invalidate();
//		this.remove(sidebar);
//		this.sidebar = invViewport;
//		this.getContentPane().add(sidebar, BorderLayout.EAST);
//		this.validate();
//		sidebar.setOpaque(false);
//		sidebar.setVisible(true);
//		invViewport.toggleVisibility();
//	}
	
	public AreaViewport getAreaViewport() {
		return areaViewport;
	}
	
	public InventoryViewport getInventoryViewport() {
		return this.invViewport;
	}
	
	public SkillPointViewport getskillPointViewport() {
		return skillPointViewport;
	}
	
	@Override
	public void paint(Graphics g1) {
		super.paint(g1);
		Graphics2D g = (Graphics2D) g1;
		
		if (gameOver) {
			Font myFont = getFont().deriveFont(48f);
			g.setFont(myFont);
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER", this.getWidth() / 2 - 200, this.getHeight() / 2);
		}
	}

	public void gameOver() {
		this.gameOver = true;
		areaViewport.stopPainting();
		sidebar.setVisible(false);
		this.validate();
	}
}
