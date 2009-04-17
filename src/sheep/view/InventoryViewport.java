package sheep.view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sheep.controller.InventoryActionListener;
import sheep.model.entities.Avatar;
import sheep.model.entities.BodyPart;
import sheep.model.entities.Inventory;
import sheep.model.items.armor.Armor;
import sheep.model.items.weapons.Weapon;
import sheep.view.overlays.Overlay;
import sheep.view.util.ResourceLoader;


/*   JM
 *   NOT DONE. WAITING FOR INVENTORY TO BE COMPLETED
 *   TODO
 *     -Add action listener for the icons. 
 *     -Add eqipped weapons to the topPnl
*/

public class InventoryViewport extends Viewport {

	private static final long serialVersionUID = 6239705575773260473L;
	public static final Color BG_COLOR = Color.black;
	public static final Dimension BUT_SIZE = new Dimension(AreaViewport.TILE_SIZE, AreaViewport.TILE_SIZE);
	private Inventory inv;
	private JPanel topPnl;
	private JPanel botPnl;
	private ResourceLoader resLoader;
	private Font myFont= Overlay.getFont();;
	
	public InventoryViewport(Avatar av, int w, int h) {
		super(av, w, h);
		setLayout(new GridLayout(2,1));
		this.inv = getAvatar().getInventory();
		resLoader = ResourceLoader.getInstance();
		setupTop();
		setupBottom();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(BG_COLOR);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
	}
	
	
	public void setupTop() {
		topPnl = new JPanel(new GridBagLayout());
		topPnl.setOpaque(false);
		
		ImageIcon placeHolder = resLoader.getImageIcon("invPlaceHolder");
		this.setFont(myFont.deriveFont(20f));
		
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
		c.gridy = 0; c.gridx = 0;
		topPnl.add(new JLabel("Eqipped "), c);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridy = 0; c2.gridx = 1;
		JButton w_but = new JButton(w_img);
		w_but.setOpaque(false);
		w_but.setPreferredSize(BUT_SIZE);
		topPnl.add(w_but, c2);

		//Aux - Create Labels, JButtons, and constraints on the layout
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridy = 1; c3.gridx = 0;
		topPnl.add(new JLabel("Auxiliary "), c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridy = 1; c4.gridx = 1;
		topPnl.add(new JButton(au_img), c4);
		
		//Chest - Create Labels, JButtons, and constraints on the layout
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridy = 2; c5.gridx = 0;
		topPnl.add(new JLabel("Chest "), c5);
		
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridy = 2; c6.gridx = 1;
		topPnl.add(new JButton(ch_img), c6);
		
		//Feet - Create Labels, JButtons, and constraints on the layout
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridy = 3; c7.gridx = 0;
		topPnl.add(new JLabel("Feet "), c7);
		
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridy = 3; c8.gridx = 1;
		topPnl.add(new JButton(fe_img), c8);
		

		this.add(topPnl, BorderLayout.NORTH);		
		topPnl.setVisible(true);
		
		
	}
	
	public void setupBottom() {
		int cols = 3;
		int rows = 5; //(int)inv.getSize() % cols;
		botPnl = new JPanel(new GridLayout(rows,cols));
		botPnl.setBackground(Color.red);
		botPnl.add(new JLabel("Items will go here"));
		/*
		for (Item item : inv.get()) {
			JButton but = new JButton(resLoader.getImageIcon(item.getID()));
			but.setSize(ICON_W,ICON_H);
			botPnl.add(but);
		}
		*/	
			/*
			 * NOT DONE... WAITING FOR A POPULATED INVENTORY BEFORE CODING MORE
			 * Todo: 
			 *   -Add action listener for theese icons. 
			 *
			 */
		this.add(botPnl, BorderLayout.SOUTH);
		botPnl.setVisible(true);
		
	}
	
	
	public void setActionListener(InventoryActionListener al) {
		throw new UnsupportedOperationException();
	}
}