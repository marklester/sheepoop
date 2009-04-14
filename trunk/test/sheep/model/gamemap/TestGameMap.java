package sheep.model.gamemap;

import sheep.model.gamemap.GameMap;

public class TestGameMap
{
	public static void main(String args[])
	{
		GameMap m = new GameMap();
		m.getMapSubset(new Location(5,4), 0);
	}
}
