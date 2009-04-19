package sheep.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import sheep.controller.TradeFacilitator;
import sheep.model.entities.Avatar;
import sheep.model.entities.Character;

public class TradeViewport extends Viewport {

	private static final long serialVersionUID = 3786317422086092333L;

	public TradeViewport(Avatar av, Character npc, TradeFacilitator tf, int x, int y) {
		super(av, 400, 400);
	
		this.setLayout( new GridLayout(1, 2) );
		
		InventoryPanel avatarInv = new InventoryPanel( av, tf, true );
		InventoryPanel npcInv = new InventoryPanel( npc, tf, false );
		
		JPanel avatarPane = new JPanel( new BorderLayout() );
		avatarPane.add( new JLabel( "Your Inventory:" ), BorderLayout.NORTH  );
		avatarPane.add( avatarInv, BorderLayout.CENTER );
		
		JPanel npcPane = new JPanel( new BorderLayout() );
		npcPane.add( new JLabel( npc.getID() + "'s Inventory:" ), BorderLayout.NORTH  );
		npcPane.add( npcInv, BorderLayout.CENTER );
		
		this.add( avatarPane );
		this.add( npcPane );
		
		this.setBounds(x, y, 400, 400);
		this.setOpaque(true);
		
		avatarPane.setVisible(true);
		npcPane.setVisible(true);
		this.validate();
	}
}
