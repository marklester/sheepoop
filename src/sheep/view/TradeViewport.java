package sheep.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import sheep.controller.TradeFacilitator;
import sheep.model.entities.Avatar;
import sheep.model.entities.Character;

public class TradeViewport extends Viewport {

	private static final long serialVersionUID = 3786317422086092333L;

	private JButton cancel;
	
	public TradeViewport(Avatar av, Character npc, TradeFacilitator tf, int x, int y) {
		super(av, 500, 500);
	
		this.setLayout( new BorderLayout() );
		
		InventoryPanel avatarInv = new InventoryPanel( av, tf, false );
		InventoryPanel npcInv = new InventoryPanel( npc, tf, true );
		
		JPanel inventPane = new JPanel( new GridLayout( 1, 2 ) );
		JPanel avatarPane = new JPanel( new BorderLayout() );
		avatarPane.add( new JLabel( "Your Inventory:" ), BorderLayout.NORTH  );
		avatarPane.add( avatarInv, BorderLayout.CENTER );
		
		JPanel npcPane = new JPanel( new BorderLayout() );
		npcPane.add( new JLabel( npc.getID() + "'s Inventory:" ), BorderLayout.NORTH  );
		npcPane.add( npcInv, BorderLayout.CENTER );
		
		inventPane.add( new JScrollPane( avatarPane ) );
		inventPane.add( new JScrollPane( npcPane ) );
		
		JPanel buttons = new JPanel( new FlowLayout( FlowLayout.TRAILING ) );
		cancel = new JButton( "Close Trade" );
		cancel.setFocusable(false);
		buttons.add( cancel );
		
		this.add( inventPane, BorderLayout.CENTER );
		this.add( buttons, BorderLayout.SOUTH );
		
		this.setBounds(x, y, 500, 500);
		this.setOpaque(true);
		
		avatarPane.setVisible(true);
		npcPane.setVisible(true);
		this.validate();
	}
	
	public void addCloseActionListener( ActionListener al ) {
		cancel.addActionListener(al);
	}
}
