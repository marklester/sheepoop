package sheep.model.gamemap;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sheep.model.Model;
import sheep.model.areaeffects.HealDamage;
import sheep.model.areaeffects.LevelUp;
import sheep.model.areaeffects.TakeDamage;
import sheep.model.entities.Vehicle;
import sheep.model.entities.npc.Wolf;

/**
 * Returns a new GameMap for level1, by loading the mapfile it knows, and adding
 * items/entities/etc to it. 
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
		//add decals
		Location loc3 = new Location(6,7);
		map.add(loc3, new Decal("LevelUp",map,loc3));
		map.add(loc3, new LevelUp(map,loc3));
		
		loc3 = new Location(6,8);
		map.add(loc3, new Decal("HealDamage",map,loc3));
		map.add(loc3, new HealDamage(map,loc3,1,1));
		loc3 = new Location(6,9);
		map.add(loc3, new TakeDamage(map,loc3,1,1));
		map.add(loc3, new Decal("TakeDamage",map,loc3));
		return map;
	}
	
}
