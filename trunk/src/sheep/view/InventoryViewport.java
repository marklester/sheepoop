package sheep.view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sheep.controller.InventoryActionListener;
import sheep.model.entities.Avatar;
import sheep.model.entities.BodyPart;
import sheep.model.entities.Inventory;
import sheep.model.items.Item;
import sheep.model.items.armor.Armor;
import sheep.model.items.weapons.Weapon;
import sheep.view.overlays.Overlay;
import sheep.view.util.ResourceLoader;


/*   JM
 *
 *   TODO
 *     -Add action listener for the icons. 
*/

public class InventoryViewport extends Viewport {

	private static final long serialVersionUID = 6239705575773260473L;
	public static final Color BG_COLOR = Color.RED;
	public static final Dimension BUT_SIZE = new Dimension(AreaViewport.TILE_SIZE, AreaViewport.TILE_SIZE);
	private Inventory inv;
	private JPanel topPnl;
	private JPanel botPnl;
	private ResourceLoader resLoader;
	private Font myFont= Overlay.getFont().deriveFont(20f);
	private Image bgImage;
	
	public InventoryViewport(Avatar av, int w, int h) {
		super(av, w, h);
		setLayout(new GridLayout(2,1));
		this.inv = getAvatar().getInventory();
		resLoader = ResourceLoader.getInstance();
		setupTop();
		setupBottom();
		bgImage = resLoader.getImage("sideBarBG");
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (bgImage != null)
			g.drawImage(bgImage, 0,0,this.getWidth(),this.getHeight(),this);
		/*
		Graphics2D g2 = (Graphics2D) g;
		Composite original = g2.getComposite();
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
		g2.setComposite(original);
		*/
	}
	
	
	
	public void setupTop() {
		topPnl = new JPanel(new GridBagLayout());
		topPnl.setOpaque(false);
		
		ImageIcon placeHolder = resLoader.getImageIcon("invPlaceHolder");
		
		//Weapon
		ImageIcon w_img;
		Weapon w = getAvatar().getEquippedWeapon();
		if (w != null)
			w_img = resLoader.getImageIcon( w.getID() );
		else
			w_img = placeHolder;

		//Aux
		ImageIcon au_img;
		Armor au = getAvatar().getEquipped(BodyPart.AUX);
		if (au != null)
			au_img = resLoader.getImageIcon( au.getID() );
		else
			au_img = placeHolder;
		
		//Head
		ImageIcon he_img;
		Armor he = getAvatar().getEquipped(BodyPart.HEAD);
		if (he != null)
			he_img = resLoader.getImageIcon( he.getID() );
		else
			he_img = placeHolder;
		
		//Chest
		ImageIcon ch_img;
		Armor ch = getAvatar().getEquipped(BodyPart.CHEST);
		if (ch != null)
			ch_img = resLoader.getImageIcon( ch.getID() );
		else
			ch_img = placeHolder;
		
		//Feet
		ImageIcon fe_img;
		Armor fe = getAvatar().getEquipped(BodyPart.FEET);
		if (fe != null)
			fe_img = resLoader.getImageIcon( fe.getID() );
		else
			fe_img = placeHolder;
		


		//Weapon - Create Labels, JButtons, and constraints on the layout
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0; c.gridx = 0; c.anchor = c.LINE_START;
		JLabel eq_la = new JLabel("Weapon");
		eq_la.setFont(myFont);
		eq_la.setForeground(Color.white);
		topPnl.add(eq_la, c);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridy = 0; c2.gridx = 1; c2.anchor = c2.CENTER;
		JButton w_but = new JButton(w_img);
		w_but.setOpaque(false);
		w_but.setPreferredSize(BUT_SIZE);
		w_but.setContentAreaFilled(false);
		topPnl.add(w_but, c2);

		//Aux - Create Labels, JButtons, and constraints on the layout
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridy = 1; c3.gridx = 0; c3.anchor = c3.LINE_START;
		JLabel au_la = new JLabel("Auxiliary");
		au_la.setFont(myFont);
		au_la.setForeground(Color.white);
		topPnl.add(au_la, c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridy = 1; c4.gridx = 1; c4.anchor = c4.CENTER;
		JButton au_but = new JButton(au_img);
		au_but.setOpaque(false);
		au_but.setPreferredSize(BUT_SIZE);
		au_but.setContentAreaFilled(false);
		topPnl.add(au_but, c4);

		//Head- Create Labels, JButtons, and constraints on the layout
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridy = 2; c5.gridx = 0; c5.anchor = c5.LINE_START;
		JLabel he_la = new JLabel("Head");
		he_la.setFont(myFont);
		he_la.setForeground(Color.white);
		topPnl.add(he_la, c5);
		
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridy = 2; c6.gridx = 1; c6.anchor = c6.CENTER;
		JButton he_but = new JButton(he_img);
		he_but.setOpaque(false);
		he_but.setContentAreaFilled(false);
		he_but.setPreferredSize(BUT_SIZE);
		topPnl.add(he_but, c6);
		
		
		//Chest - Create Labels, JButtons, and constraints on the layout
		GridBagConstraints c6a = new GridBagConstraints();
		c6a.gridy = 3; c6a.gridx = 0; c6a.anchor = c6a.LINE_START;
		JLabel ch_la = new JLabel("Chest");
		ch_la.setFont(myFont);
		ch_la.setForeground(Color.white);
		topPnl.add(ch_la, c6a);
		
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridy = 3; c7.gridx = 1; c7.anchor = c7.CENTER;
		JButton ch_but = new JButton(ch_img);
		ch_but.setOpaque(false);
		ch_but.setContentAreaFilled(false);
		ch_but.setPreferredSize(BUT_SIZE);
		topPnl.add(ch_but, c7);
		
		//Feet - Create Labels, JButtons, and constraints on the layout
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridy = 4; c8.gridx = 0; c8.anchor = c8.LINE_START;
		JLabel fe_la = new JLabel("Feet");
		fe_la.setFont(myFont);
		fe_la.setForeground(Color.white);
		topPnl.add(fe_la, c8);
		
		GridBagConstraints c9 = new GridBagConstraints();
		c9.gridy = 4; c9.gridx = 1; c9.anchor = c9.CENTER;
		JButton fe_but = new JButton(fe_img);
		fe_but.setContentAreaFilled(false);
		fe_but.setOpaque(false);
		fe_but.setPreferredSize(BUT_SIZE);
		topPnl.add(fe_but, c9);
		

		this.add(topPnl, BorderLayout.NORTH);		
		topPnl.setVisible(true);
		
		
	}
	
	public void setupBottom() {
		botPnl = new JPanel(new GridBagLayout());
		Dimension d = this.getPreferredSize();
		botPnl.setPreferredSize(new Dimension((int)d.getWidth(), (int)d.getHeight() / 2));
		botPnl.setOpaque(false);
		
		short cols = 2;
		short x=0;
		short y=0;
		for (Item item : inv.get()) {
			if (x == cols) 
				{ x=0; y++; }
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = x++; c.gridy = y;
			JButton but = new JButton(resLoader.getImageIcon(item.getID()));
			but.setPreferredSize(BUT_SIZE);
			but.setOpaque(false);
			botPnl.add(but, c);
		}
		
		this.add(botPnl, BorderLayout.SOUTH);
		botPnl.setVisible(true);
		
	}
	
	
	public void setActionListener(InventoryActionListener al) {
		throw new UnsupportedOperationException();
	}
}