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
import sheep.model.items.Trap;
import sheep.model.items.armor.SteelWool;
import sheep.model.items.oneshot.Beer;
import sheep.model.items.oneshot.Key;
import sheep.model.items.oneshot.Syringe;
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
		Location loc;
		loc = new Location(0, 17);
		Vehicle vehicle = new Vehicle("Boat", model, loc);
		map.add(loc, vehicle);

		// Add wolfs
		loc = new Location(6, 6);
		map.add(loc, new Wolf(model, loc));
		loc = new Location(17, 14);
		map.add(loc, new AngryWolf(model, loc));

		// add a level up w/ decal
		loc = new Location(6, 7);
		map.add(loc, new Decal("LevelUp", model, loc));
		map.add(loc, new LevelUp(model, loc));

		// Heal Damage
		loc = new Location(6, 8);
		map.add(loc, new Decal("HealDamage", model, loc));
		map.add(loc, new HealDamage(model, loc, 25, 5));

		// Take Damage
		loc = new Location(6, 9);
		map.add(loc, new TakeDamage(model, loc, 25, 5));
		map.add(loc, new Decal("TakeDamage", model, loc));
		
		loc = new Location(9, 5);
		map.add(loc, new TakeDamage(model, loc, 25, 30));
		map.add(loc, new Decal("TakeDamage", model, loc));
		
		// Trap decal (we need to make this a real trap)
		loc = new Location(14, 8);
		map.add(loc, new Trap(model, loc,20));

		// Teleporter
		loc = new Location(18, 1);
		map.add(loc, new Teleport(model, loc, new Location(7, 13)));

		// Steel Wool Armor
		loc = new Location(5, 8);
		map.add(loc, new SteelWool(model, loc));

		// Lighting spell
		loc = new Location(5, 7);
		map.add(loc, new HeavyAxe(model, loc));
		
		// Beer
		loc = new Location(15, 7);
		map.add(loc, new Beer(model, loc));
		
		// Syringe
		loc = new Location(18, 8);
		map.add(loc, new Syringe(model, loc));
		
		// Key
		loc = new Location(18, 13);
		map.add(loc, new Key(model, loc));

		return map;
	}

}
