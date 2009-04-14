package sheep.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sheep.controller.InventoryActionListener;
import sheep.model.entities.Avatar;
import sheep.model.entities.Inventory;
import sheep.model.items.Item;
import sheep.view.util.ResourceLoader;


/*   JM
 *   NOT DONE. WAITING FOR INVENTORY TO BE COMPLETED
 *   TODO
 *     -Add action listener for the icons. 
 *     -Add eqipped weapons to the topPnl
*/






public class InventoryViewport extends JPanel {

	private static final long serialVersionUID = 6239705575773260473L;
	public static final int ICON_W = 20;
	public static final int ICON_H = 20;

	private Avatar avatar;
	private Inventory inv;
	private JPanel topPnl;
	private JPanel botPnl;
	private ResourceLoader resLoader;
	
	public InventoryViewport(Avatar avatar) {
		this.avatar = avatar;
		this.inv = avatar.getInventory();
		setupTop();
		resLoader = ResourceLoader.getInstance();
	}
	
	
	public void setupTop() {
		topPnl = new JPanel(new GridLayout(6,0));
		Dimension d = this.getSize();
		topPnl.setSize(new Dimension((int)d.getWidth(), (int)d.getHeight()/3));
		
		topPnl.add(new JLabel("Eqipped "));
		topPnl.add(new JLabel("   Hand "));
		topPnl.add(new JLabel("   Aux  "));
		topPnl.add(new JLabel("   Head "));
		topPnl.add(new JLabel("   Body "));
		topPnl.add(new JLabel("   Feet "));
		this.add(topPnl, BorderLayout.NORTH);
		topPnl.setVisible(true);
		
	}
	
	public void setupBottom() {
		int cols = 3;
		int rows = (int)inv.getSize() % cols;
		botPnl = new JPanel(new GridLayout(rows,cols));
		Dimension d = this.getPreferredSize();
		botPnl.setSize(new Dimension((int)d.getWidth(), (int)d.getHeight()/3));
		for (Item item : inv.get()) {
			JButton but = new JButton(resLoader.getImageIcon(item.getID()));
			but.setSize(ICON_W,ICON_H);
			topPnl.add(but);
			
			/*
			 * NOT DONE... WAITING FOR A POPULATED INVENTORY BEFORE CODING MORE
			 * Todo: 
			 *   -Add action listener for theese icons. 
			 *
			 */
		}
		
	}
	
	
	public void setActionListener(InventoryActionListener al) {
		throw new UnsupportedOperationException();
	}
}