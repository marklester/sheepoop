package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.entities.Character;
import sheep.model.gamemap.GameMap;
import sheep.model.items.Takeable;

public class DropItemAction extends AbstractAction {

	private static final long serialVersionUID = 2079589631844384723L;
	private Character target;
	private Takeable item;

	public DropItemAction(Character target, Takeable item) {
		this.target = target;
		this.item = item;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		GameMap map = target.getGameMap();
		
		if( target.removeItem( item ) )
			map.add( target.getLocation(), item );
	}
}