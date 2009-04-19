package sheep.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import sheep.controller.BuyTradeListener;
import sheep.controller.SellTradeListener;
import sheep.controller.TradeFacilitator;
import sheep.model.entities.Character;
import sheep.model.entities.Inventory;
import sheep.model.entities.InventoryChange;
import sheep.model.entities.InventoryChangeObserver;
import sheep.model.items.Takeable;
import sheep.view.util.ResourceLoader;

public class InventoryPanel extends Viewport implements InventoryChangeObserver {

	private static final long serialVersionUID = 7194480675430931430L;
	
	private TradeFacilitator tf;
	private Inventory inventory;
	private JPanel invList;
	private boolean buy;

	public InventoryPanel( Character character, TradeFacilitator tf, boolean buy )
	{
		super( null );
		this.inventory = character.getInventory();
		character.registerInventoryChangeObserver( this );
		this.buy = buy;
		this.tf = tf;
		
		this.setLayout( new BorderLayout() );
		setUpPanel();
	}
	
	public void setUpPanel()
	{
		if( invList != null )
			this.remove( invList );
		
		invList = createBottomPanel();
		this.add( invList, BorderLayout.CENTER );
		this.validate();
	}
	
	public JPanel createBottomPanel() {
		JPanel botPnl = new JPanel(new GridBagLayout());
		Dimension d = this.getPreferredSize();
		botPnl.setPreferredSize(new Dimension((int) d.getWidth(), (int) d.getHeight() / 2));
		botPnl.setOpaque(false);
		botPnl.setFocusable(false);

		short cols = 2;
		short x = 0;
		short y = 0;
		for (Takeable item : inventory.get()) {
			if (x == cols) {
				x = 0;
				y++;
			}
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = x++;
			c.gridy = y;
			JButton but = new JButton( ResourceLoader.getInstance().getImageIcon(item.getID()));
			but.setPreferredSize(BUT_SIZE);
			but.setOpaque(false);
			but.setContentAreaFilled(false);
			but.setFocusable(false);
			but.setActionCommand(item.getID() );
			but.addActionListener( (buy) ? new BuyTradeListener(tf, item) : new SellTradeListener(tf, item) );
			botPnl.add(but, c);
		}

		botPnl.setVisible(true);

		return botPnl;
	}

	@Override
	public void update(InventoryChange msg) {
		setUpPanel();
	}
}