package sheep.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sheep.model.entities.Avatar;
import sheep.model.entities.BodyPart;
import sheep.model.items.Takeable;

/**
 * 
 * @author Jason Mac
 *
 */

public class EquipmentActionListener implements ActionListener {

	private final Avatar avatar;
	private BodyPart where;
	
	//Constructs a listener for the Weapon of the avatar
	public EquipmentActionListener(Avatar avatar) {
		this.avatar = avatar;
	}
	
	//Constructs a listener for the Armor at a specific body part of the avatar
	public EquipmentActionListener(Avatar avatar, BodyPart where) {
		this.avatar = avatar;
		this.where = where;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (where == null) 
			avatar.unequipWeapon();
		else
			avatar.unequipArmor(where);

	}

}
