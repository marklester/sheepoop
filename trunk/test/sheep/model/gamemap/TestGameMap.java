package sheep.model.gamemap;

import sheep.model.terrains.Mountain;
import sheep.model.terrains.Water;

public class TestGameMap
{
	public static void main(String args[])
	{
		GameMap m = new GameMap();
		
		Location l;
		
		l = new Location(0,0);
		m.add(l, new Water(m, l));
		//l = new Location(0,1);
		m.add(l, new Mountain(m, l));
		
		System.out.println(m.get(new Location(0,0)));
		
		m.getMapSubset(l, 3);
	}
}
