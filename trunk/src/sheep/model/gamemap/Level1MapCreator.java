package sheep.model.gamemap;

import java.io.File;
import java.io.IOException;

import sheep.model.Model;
import sheep.model.areaeffects.HealDamage;
import sheep.model.areaeffects.LevelUp;
import sheep.model.areaeffects.TakeDamage;
import sheep.model.areaeffects.Teleport;
import sheep.model.entities.Vehicle;
import sheep.model.entities.npc.AngryWolf;
import sheep.model.entities.npc.Wolf;
import sheep.model.items.armor.SteelWool;
import sheep.model.items.weapons.Lightning;

/**
 * Returns a new GameMap for level1, by loading the mapfile it knows, and adding
 * items/entities/etc to it.
 */
public class Level1MapCreator extends MapCreator {

	private static File mapFile = new File("res/maps/level1.txt");

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
		loc1 = new Location(0, 17);
		Vehicle vehicle = new Vehicle("Boat", map, loc1, model);
		map.add(loc1, vehicle);

		// Add wolfs
		Location loc2 = new Location(6, 6);
		map.add(loc2, new Wolf(map, loc2, model));
		loc2 = new Location(17, 14);
		map.add(loc2, new AngryWolf(map, loc2, model));

		// add a level up w/ decal
		Location loc3 = new Location(6, 7);
		map.add(loc3, new Decal("LevelUp", map, loc3));
		map.add(loc3, new LevelUp(map, loc3));

		// Heal Damage
		loc3 = new Location(6, 8);
		map.add(loc3, new Decal("HealDamage", map, loc3));
		map.add(loc3, new HealDamage(map, loc3, 25, 5));

		// Take Damage
		loc3 = new Location(6, 9);
		map.add(loc3, new TakeDamage(map, loc3, 25, 5));
		map.add(loc3, new Decal("TakeDamage", map, loc3));
		
		loc3 = new Location(9, 5);
		map.add(loc3, new TakeDamage(map, loc3, 25, 30));
		map.add(loc3, new Decal("TakeDamage", map, loc3));
		
		// Trap decal (we need to make this a real trap)
		loc3 = new Location(14, 8);
		map.add(loc3, new Decal("Trap", map, loc3));

		// Teleporter
		loc3 = new Location(18, 1);
		map.add(loc3, new Teleport(model, loc3, new Location(7, 13)));

		// Steel Wool Armor
		loc3 = new Location(5, 8);
		map.add(loc3, new SteelWool(map, loc3));

		// Lighting spell
		loc3 = new Location(5, 7);
		map.add(loc3, new Lightning(map, loc3));

		return map;
	}

}
