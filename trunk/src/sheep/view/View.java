package sheep.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
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
	private JLayeredPane layers;
	private SkillPointViewport skillPointViewport;
	private AreaViewport areaViewport;
	private InventoryViewport invViewport;
	private InteractionViewport interactionViewport;
	private JPanel sidebar;
	private boolean gameOver = false; 

	public View(Model model) {
		this.model = model;
		setUpFrame();
		
		//Initialize Viewports
		invViewport = new InventoryViewport(model.getAvatar(), SIDE_BAR_W, this.getHeight());
		skillPointViewport = new SkillPointViewport(model.getAvatar(), SIDE_BAR_W, this.getHeight());
		showSidebarViewport(invViewport);
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
		
		// Setup layering
		layers = this.getLayeredPane();
        
		// Create area viewport
		areaViewport = new AreaViewport(this.model, this.model.getGameMap());
		areaViewport.setBackground(Color.BLACK);
		areaViewport.setBounds(0, 0, this.getWidth() - SIDE_BAR_W, this.getHeight());
		areaViewport.setOpaque(true);
		layers.add(areaViewport, new Integer(0));
		

//		JButton btn = new JButton("hi");
//		btn.setBackground(Color.RED);
//		btn.setOpaque(true);
//		btn.setBounds(900, 200, 300, 40);
//		layers.add(btn, new Integer(400));

		// Create sidebar placeholder
		sidebar = new Viewport(model.getAvatar());
		sidebar.setOpaque(true);
		sidebar.setBounds(this.getWidth() - SIDE_BAR_W, 0, SIDE_BAR_W, this.getHeight());
		layers.add(sidebar, new Integer(0));

		// Tell viewports they can DO THEIR THANG
		areaViewport.initialize();
		
		// Show window
		areaViewport.setFocusable(true);
		
		validate();
		this.setVisible(true);
	}

	public void showSidebarViewport(Viewport theViewP) {
		this.invalidate();
		layers.remove(sidebar);
		((Viewport)sidebar).toggleVisibility(); //sorta ghetto, sorry.
		sidebar = theViewP;
		sidebar.setOpaque(true);
		sidebar.setBounds(this.getWidth() - SIDE_BAR_W, 0, SIDE_BAR_W, this.getHeight());
		layers.add(sidebar, new Integer(0));
		this.validate();
		sidebar.setVisible(true);
		theViewP.toggleVisibility();
	}

	public AreaViewport getAreaViewport() {
		return areaViewport;
	}
	
	public InventoryViewport getInventoryViewport() {
		return this.invViewport;
	}
	
//	@Override
//	public void paint(Graphics g1) {
//		super.paint(g1);
//		Graphics2D g = (Graphics2D) g1;
//		
//	//	this.layers.paint(g);
//		
//		if (gameOver) {
//			Font myFont = getFont().deriveFont(48f);
//			g.setFont(myFont);
//			g.setColor(Color.WHITE);
//			g.drawString("GAME OVER", this.getWidth() / 2 - 200, this.getHeight() / 2);
//		}
//	}

	public SkillPointViewport getskillPointViewport() {
		return skillPointViewport;
	}

	public void gameOver() {
		this.gameOver = true;
		areaViewport.stopPainting();
		sidebar.setVisible(false);
		this.validate();
	}
	
	private JLayeredPane makeLayers() {
		JLayeredPane j = new JLayeredPane();
		j.setPreferredSize(this.getSize());
		j.validate();
		j.setOpaque(true);
		return j;
	}

	public void pausedActionMenu() {
	}

}
