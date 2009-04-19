package sheep.controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import sheep.model.entities.Avatar;

public class UseWeaponAction extends AbstractAction {

	private static final long serialVersionUID = 6119775843258180224L;
	private Avatar attacker;

	int count = 0;
	public UseWeaponAction(Avatar attacker) {
		this.attacker = attacker;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (attacker != null && attacker.getEquippedWeapon() != null) {
			attacker.getEquippedWeapon().actionPerformed(ae);
			count++;
			System.out.println("[UseWeaponAction] I' m being called"+count);
		}
	}
}