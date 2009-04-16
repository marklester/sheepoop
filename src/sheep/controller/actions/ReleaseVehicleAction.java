package sheep.controller.actions;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;

import sheep.model.Model;
import sheep.model.entities.Avatar;
import sheep.model.entities.Entity;
import sheep.model.entities.Vehicle;
import sheep.model.gamemap.Locatable;

/**
 * Make the avatar get out of a vehicle
 * @author Phil Freo
 */
public class ReleaseVehicleAction extends AbstractAction {

	private static final long serialVersionUID = -1934297505909650891L;

	private final Model model;
	
	public ReleaseVehicleAction(Model model) {
		super();
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Entity mover = model.getMover();
		Avatar avatar = model.getAvatar();
		
		// Do nothing if the avatar isn't in a vehicle
		if (mover == avatar) {
			return;
		}
		Vehicle vehicle = (Vehicle) mover;
		
		// Do nothing if the vehicle is currently on a terrain the avatar can't
		// go on by itself
		List<Locatable> thingsOnMyTile = model.getGameMap().get(vehicle.getLocation());
		for (Locatable locatable : thingsOnMyTile) {
			if (locatable.blocks(avatar)) {
				return;
			}
		}
		
		// Release vehicle
		vehicle.clearDriver();
		model.setMover((Entity)model.getAvatar());
	}

}