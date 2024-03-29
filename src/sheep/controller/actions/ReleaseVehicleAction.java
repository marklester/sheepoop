package sheep.controller.actions;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.AbstractAction;

import sheep.model.Model;
import sheep.model.entities.Avatar;
import sheep.model.entities.Entity;
import sheep.model.entities.vehicles.Vehicle;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;

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

		// Do nothing if the vehicle isn't currently next to a terrain the 
		// avatar can't go on by itself
		Map<Location, List<Locatable>> thingsOnMyTile = model.getGameMap().getMapSubset(vehicle.getLocation(), 1);

		// Look for a terrain next to vehicle that the avatar can get off
		boolean avatarCanGetOff = true; 
		Location passableLoc = null;
		for(Locatable l: model.getGameMap().get(mover.getLocation()))
		{
			if (l != vehicle && l != avatar && l.blocks(avatar)) {
				avatarCanGetOff = false;
				break;
			}	
		}
		if(!avatarCanGetOff)
		{
			for (Entry<Location, List<Locatable>> locatables : thingsOnMyTile.entrySet()) {
				avatarCanGetOff = true;
				for (Locatable locatable : locatables.getValue()) {
					passableLoc = locatable.getLocation();
					if (locatable != vehicle && locatable != avatar && locatable.blocks(avatar)) {
						avatarCanGetOff = false;
						break;
					}				
				}
				if(avatarCanGetOff)
				{
					break;
				}
			}

			// Don't release vehicle if avatar can't get off
			if (!avatarCanGetOff) {
				return;
			}

			for(Locatable l: model.getGameMap().get(passableLoc))
			{
				if((l!=vehicle)&&(l!=avatar)&&l.blocks(avatar))
				{
					return;
				}
			}
			// Move vehicle (and avatar) to nearest passable tile
			mover.setLocation(passableLoc);

			// Release vehicle
			vehicle.clearDriver();
			model.setMover((Entity)model.getAvatar());
			vehicle.stopMoving();
		}
		else
		{
			vehicle.clearDriver();
			model.setMover((Entity)model.getAvatar());
			vehicle.stopMoving();
		}
	}

}