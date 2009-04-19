package sheep.model.areaeffects;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import sheep.model.Time;
import sheep.model.TimeObserver;
import sheep.model.entities.Entity;
import sheep.model.gamemap.Location;
import sheep.util.math.Vector2D;

public class RiverCounter implements TimeObserver, Serializable
{
	static final long serialVersionUID = 1L;
	Map<Entity, Integer> entitiesInStream;
	Map<Location, River> riversMakingUpStream;

	public RiverCounter()
	{
		entitiesInStream = new ConcurrentHashMap<Entity, Integer>();
		riversMakingUpStream = new ConcurrentHashMap<Location, River>();
		Time.getInstance().registerObserver(this);
	}
	public void addEntityToStream(Entity e)
	{
		int severity = riversMakingUpStream.get(e.getLocation()).getMyFrequency();
		if(entitiesInStream.get(e)==null)
		{
			entitiesInStream.put(e, severity);
		}
		else if(entitiesInStream.get(e)>=severity)
		{
			entitiesInStream.put(e, severity);
		}
	}
	public void addRiverToStream(River r)
	{
		riversMakingUpStream.put(r.getLocation(), r);
	}
	@Override
	public void tick()
	{
		Iterator<Entity> myIt = entitiesInStream.keySet().iterator();
		Entity e;
		Location eLoc;
		River r;
		while(myIt.hasNext())
		{
			e = myIt.next();
			eLoc = e.getLocation();
			if(eLoc!=null)
			{
				r = riversMakingUpStream.get(eLoc);
				if(r!=null)
				{
					int i = entitiesInStream.get(e);
					if(i > 0)
					{
						i--;
						entitiesInStream.put(e, i);
						//System.out.println(e);
					}
					else
					{
						Vector2D dir = r.getDirection().getVector(eLoc);
						Location dest = new Location(eLoc.getX()+(int)dir.getX(),eLoc.getY()+(int)dir.getY());
						e.move(dest);
						entitiesInStream.put(e, r.getMyFrequency());
					}
				}
				else
				{
					entitiesInStream.remove(e);
				}
			}
		}
	}
}
