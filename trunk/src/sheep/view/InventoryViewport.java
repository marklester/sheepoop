package sheep.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sheep.controller.InventoryActionListener;
import sheep.model.entities.Avatar;
import sheep.model.entities.Inventory;
import sheep.model.items.weapons.Weapon;
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
	public static final Dimension butDimension = new Dimension(AreaViewport.TILE_SIZE, AreaViewport.TILE_SIZE );
	private Inventory inv;
	private JPanel topPnl;
	private JPanel botPnl;
	private ResourceLoader resLoader;
	
	public InventoryViewport(Avatar av, int w, int h) {
		super(av, w, h);
		setLayout(new GridLayout(2,1));
		this.inv = getAvatar().getInventory();
		resLoader = ResourceLoader.getInstance();
		setupTop();
		setupBottom();
	}
	
	
	public void setupTop() {
		ImageIcon placeHolder = resLoader.getImageIcon("invPlaceHolder");
		ImageIcon w_img;
		
		//Weapon
		Weapon w = getAvatar().getEquippedWeapon();
		if (w != null)
			w_img = resLoader.getImageIcon( w.getID() );
		else
			w_img = placeHolder;
		JButton w_but = new JButton(w_img);
		w_but.setPreferredSize(butDimension);
		
		
		topPnl = new JPanel(new GridLayout(6,2));
		topPnl.setBackground(Color.green);
		
		topPnl.add(new JLabel("Eqipped "));
		topPnl.add(new JButton(w_img));
		
		topPnl.add(new JLabel("   Hand "));
		topPnl.add(new JButton(w_img));
		
		topPnl.add(new JLabel("   Aux  "));
		topPnl.add(new JButton(w_img));
		
		topPnl.add(new JLabel("   Head "));
		topPnl.add(new JButton(w_img));
		
		topPnl.add(new JLabel("   Body "));
		topPnl.add(new JButton(w_img));
		
		topPnl.add(new JLabel("   Feet "));
		topPnl.add(new JButton(w_img));
		
		this.add(topPnl, BorderLayout.NORTH);
		
//		Graphics2D g = (Graphics2D) topPnl.getGraphics();
//		g.setBackground(BG_COLOR);
//		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
		
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