package sheep.model.entities.npc.ai;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import sheep.model.Model;
import sheep.model.Time;
import sheep.model.entities.Avatar;
import sheep.model.entities.Entity;
import sheep.model.entities.npc.NPC;
import sheep.model.entities.vehicles.Boat;
import sheep.model.entities.vehicles.Vehicle;
import sheep.model.gamemap.Direction;
import sheep.model.gamemap.Locatable;
import sheep.model.gamemap.Location;
import sheep.util.math.Vector2D;

public class TPayneAI extends AI
{
	private static final long serialVersionUID = 7030862334838159685L;

	Boat myBoat;
	NPC myNPC;
	boolean onABoat;
	boolean inARiver;
	int ticksToMove;
	int speed;

	public TPayneAI(Model model, Boat myBoat)
	{
		super(model);
		onABoat = false;
		inARiver = false;
		this.myBoat = myBoat;
		speed = 12;
		ticksToMove = speed;
	}

	@Override
	public void bumpedIntoAvatar(Avatar avatar)
	{
		//do nothing
	}

	public void setMyNpc(NPC myNPC)
	{
		this.myNPC = myNPC;
		Time.getInstance().registerObserver(this);
	}
	@Override
	public void tick()
	{
		if(ticksToMove>0&&((!onABoat)||(!inARiver)))
		{
			ticksToMove--;
		}
		else if(!onABoat)
		{
			if(myNPC.getLocation().equals(myBoat.getLocation()))
			{
				myBoat.setDriver(myNPC);
				onABoat = true;
				ticksToMove = 0;
			}
			else
			{
				Location myLoc = myNPC.getLocation();
				Vector2D myVec = dirToBoat().getVector(myLoc);
				myNPC.move(new Location(myLoc.getX() + (int)myVec.getX(), myLoc.getY()+(int)myVec.getY()));
				ticksToMove = speed;
			}
		}
		else if(!inARiver)
		{
			// Do nothing if the vehicle isn't currently next to a terrain the 
			// avatar can't go on by itself
			Map<Location, List<Locatable>> thingsOnMyTile = getModel().getGameMap().getMapSubset(myBoat.getLocation(), 1);
			
			// Look for a terrain next to vehicle that the avatar can get off
			boolean avatarCanGetOff = true; 
			Location passableLoc = null;
			for (Entry<Location, List<Locatable>> locatables : thingsOnMyTile.entrySet()) {
				avatarCanGetOff = true;
				for (Locatable locatable : locatables.getValue()) {
					passableLoc = locatable.getLocation();
					if (locatable != myBoat && locatable != myNPC && locatable.blocks(myBoat)) {
						avatarCanGetOff = false;
						break;
					}				
				}
				if(avatarCanGetOff)
				{
					inARiver = true;
					myBoat.move(passableLoc);
					break;
				}
			}
		}

	}
	private Direction dirToBoat()
	{
		Location boatLoc = myBoat.getLocation();
		Location npcLoc = myNPC.getLocation();
		Direction dirToBoat;
		if (Math.abs(boatLoc.getX() - npcLoc.getX()) > Math.abs(boatLoc.getY() - npcLoc.getY())) {
			// move left or right
			if (boatLoc.getX() < npcLoc.getX()) { 
				// avatar is left
				if (boatLoc.getY() < npcLoc.getY()) {
					// avatar is up
					dirToBoat = Direction.NW;
				} else {
					// avatar is down
					dirToBoat = Direction.SW;
				}
			} else {
				// avatar is right
				if (boatLoc.getY() < npcLoc.getY()) {
					// avatar is up
					dirToBoat = Direction.NE;
				} else {
					// avatar is down
					dirToBoat = Direction.SE;
				}
			}
		} else {
			if (boatLoc.getY() < npcLoc.getY()) {
				// avatar is up
				dirToBoat = Direction.N;
			} else {
				// avatar is down
				dirToBoat = Direction.S;
			}
		}
		return(dirToBoat);
	}
}
