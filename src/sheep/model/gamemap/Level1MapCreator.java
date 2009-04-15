package sheep.model.gamemap;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sheep.model.Model;
import sheep.model.entities.Vehicle;
import sheep.model.entities.npc.Wolf;

/**
 * Takes a map file 
 * @author Phil Freo
 */
public class Level1MapCreator extends MapCreator {

	private static File mapFile = new File("res/maps/testmapone.txt");
	
	public GameMap createMap(Model model) {
		
		// Get initial map from parsed map file
		GameMap map = null;
		try {
			map = super.parseMapFile(mapFile);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("MapCreator.parseMap failed;");
			System.exit(1);
		}
				
		// Add vehicles
		Location loc1;
		loc1 = new Location(9, 7);
		Vehicle vehicle = new Vehicle("Boat", map, loc1, model);
		map.add(loc1, vehicle);
		
		// Add wolfs
		List<Location> locations = new ArrayList<Location>();
		locations.add(new Location(6, 6));
		locations.add(new Location(8, 8));
		locations.add(new Location(10, 3));
		locations.add(new Location(12, 12));
		for (Location loc2 : locations) {
			map.add(loc2, new Wolf(map, loc2));
		}
		
		return map;
	}
	
}
