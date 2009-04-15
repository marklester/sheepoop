package sheep.controller.actions;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;

import sheep.model.Model;
import sheep.model.entities.Entity;
import sheep.model.entities.Vehicle;
import sheep.model.gamemap.Locatable;
import sheep.model.terrains.Water;

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
		
		// Do nothing if the avatar isn't in a vehicle
		if (!(mover instanceof Vehicle)) {
			return;
		}
		Vehicle vehicle = (Vehicle) mover;
		
		// Do nothing if the vehicle is currently in water
		List<Locatable> thingsOnMyTile = model.getGameMap().get(vehicle.getLocation());
		for (Locatable locatable : thingsOnMyTile) {
			if (locatable instanceof Water) {
				return;
			}
		}
		
		// Release vehicle
		vehicle.clearDriver();
		model.setMover((Entity)model.getAvatar());
	}

}