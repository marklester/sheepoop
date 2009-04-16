package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.entities.Entity;
import sheep.model.items.weapons.Weapon;

public class UseWeaponAction extends AbstractAction {

	private static final long serialVersionUID = 6119775843258180224L;
	private Entity attacker;
	private Weapon weapon;
	
	public UseWeaponAction( Entity attacker, Weapon weapon ) {
		this.attacker = attacker;
		this.weapon = weapon;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		weapon.actionPerformed( ae );
	}
}