package sheep.model.gamemap;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sheep.model.Model;
import sheep.model.areaeffects.HealDamage;
import sheep.model.areaeffects.LevelUp;
import sheep.model.areaeffects.TakeDamage;
import sheep.model.areaeffects.Teleport;
import sheep.model.entities.Vehicle;
import sheep.model.entities.npc.Wolf;
import sheep.model.items.armor.SteelWool;
import sheep.model.items.weapons.Lightning;

/**
 * Returns a new GameMap for level1, by loading the mapfile it knows, and adding
 * items/entities/etc to it. 
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
		loc1 = new Location(11, 14);
		Vehicle vehicle = new Vehicle("Boat", map, loc1, model);
		map.add(loc1, vehicle);
		
		// Add wolfs
		List<Location> locations = new ArrayList<Location>();
		locations.add(new Location(6, 6));
		locations.add(new Location(3, 3));
		for (Location loc2 : locations) {
			map.add(loc2, new Wolf(map, loc2, model));
		}
		
		//add a level up w/ decal
		Location loc3 = new Location(6,7);
		map.add(loc3, new Decal("LevelUp",map,loc3));
		map.add(loc3, new LevelUp(map,loc3));
		
		//Heal Damage
		loc3 = new Location(6,8);
		map.add(loc3, new Decal("HealDamage",map,loc3));
		map.add(loc3, new HealDamage(map,loc3,25,5));
		loc3 = new Location(6,9);
		
		//Take Damage
		map.add(loc3, new TakeDamage(map,loc3,25,5));
		map.add(loc3, new Decal("TakeDamage",map,loc3));
		
		//Teleporter
		loc3 = new Location(6,10);
		map.add(loc3, new Teleport(map,loc3,new Location(11,16)));
		
		//Steel Wool Armor
		loc3 = new Location(5,8);
		map.add(loc3, new SteelWool(map,loc3));
		
		//Lighting spell
		loc3 = new Location(5,7);
		map.add(loc3, new Lightning(map,loc3));
		
		return map;
	}
	
}
