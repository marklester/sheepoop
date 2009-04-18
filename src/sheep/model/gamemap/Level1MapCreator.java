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
import sheep.model.items.weapons.HeavyAxe;

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
			map = super.parseMapFile(model, mapFile);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("MapCreator.parseMap failed;");
			System.exit(1);
		}

		// Add vehicles
		Location loc1;
		loc1 = new Location(0, 17);
		Vehicle vehicle = new Vehicle("Boat", model, loc1);
		map.add(loc1, vehicle);

		// Add wolfs
		Location loc2 = new Location(6, 6);
		map.add(loc2, new Wolf(model, loc2));
		loc2 = new Location(17, 14);
		map.add(loc2, new AngryWolf(model, loc2));

		// add a level up w/ decal
		Location loc3 = new Location(6, 7);
		map.add(loc3, new Decal("LevelUp", model, loc3));
		map.add(loc3, new LevelUp(model, loc3));

		// Heal Damage
		loc3 = new Location(6, 8);
		map.add(loc3, new Decal("HealDamage", model, loc3));
		map.add(loc3, new HealDamage(model, loc3, 25, 5));

		// Take Damage
		loc3 = new Location(6, 9);
		map.add(loc3, new TakeDamage(model, loc3, 25, 5));
		map.add(loc3, new Decal("TakeDamage", model, loc3));
		
		loc3 = new Location(9, 5);
		map.add(loc3, new TakeDamage(model, loc3, 25, 30));
		map.add(loc3, new Decal("TakeDamage", model, loc3));
		
		// Trap decal (we need to make this a real trap)
		loc3 = new Location(14, 8);
		map.add(loc3, new Decal("Trap", model, loc3));

		// Teleporter
		loc3 = new Location(18, 1);
		map.add(loc3, new Teleport(model, loc3, new Location(7, 13)));

		// Steel Wool Armor
		loc3 = new Location(5, 8);
		map.add(loc3, new SteelWool(model, loc3));

		// Lighting spell
		loc3 = new Location(5, 7);
		map.add(loc3, new HeavyAxe(model, loc3));

		return map;
	}

}
