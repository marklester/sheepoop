package sheep.model.gamemap;

import java.io.File;
import java.io.IOException;

import sheep.model.Model;
import sheep.model.Time;
import sheep.model.areaeffects.HealDamage;
import sheep.model.areaeffects.LevelUp;
import sheep.model.areaeffects.River;
import sheep.model.areaeffects.RiverCounter;
import sheep.model.areaeffects.TakeDamage;
import sheep.model.areaeffects.Teleport;
import sheep.model.entities.npc.AngrySpider;
import sheep.model.entities.npc.AreMyRat;
import sheep.model.entities.npc.NPC;
import sheep.model.entities.npc.Spider;
import sheep.model.entities.npc.TPayne;
import sheep.model.entities.npc.ai.TPayneAI;
import sheep.model.entities.vehicles.Boat;
import sheep.model.entities.vehicles.Plane;
import sheep.model.entities.vehicles.TPBoat;
import sheep.model.entities.vehicles.Vehicle;
import sheep.model.items.Trap;
import sheep.model.items.armor.BikeHelmet;
import sheep.model.items.armor.BronzeWool;
import sheep.model.items.armor.CrossTrainers;
import sheep.model.items.armor.MarlinsCap;
import sheep.model.items.armor.SheepSandals;
import sheep.model.items.armor.Shield;
import sheep.model.items.armor.SteelToedShoes;
import sheep.model.items.armor.SteelWool;
import sheep.model.items.interactive.FlowReverser;
import sheep.model.items.interactive.FreeBoatRideFor3;
import sheep.model.items.interactive.PilotLicense;
import sheep.model.items.oneshot.Beer;
import sheep.model.items.oneshot.Key;
import sheep.model.items.oneshot.Syringe;
import sheep.model.items.useable.HappyMeal;
import sheep.model.items.useable.Mana;
import sheep.model.items.useable.OrangeJuice;
import sheep.model.items.useable.WheatThins;
import sheep.model.items.weapons.AshStaff;
import sheep.model.items.weapons.CrossBow;
import sheep.model.items.weapons.FlareGun;
import sheep.model.items.weapons.GoldStaff;
import sheep.model.items.weapons.Hammer;
import sheep.model.items.weapons.HeavyAxe;
import sheep.model.items.weapons.LongSword;
import sheep.model.items.weapons.Nunchucks;
import sheep.model.items.weapons.OakStaff;
import sheep.model.items.weapons.ShortSword;
import sheep.model.items.weapons.SpearGun;
import sheep.model.items.weapons.Trident;
import sheep.model.items.weapons.spells.CalmAnimal;
import sheep.model.items.weapons.spells.EnrageAnimal;
import sheep.model.items.weapons.spells.Fire;
import sheep.model.items.weapons.spells.GaeasCradle;
import sheep.model.items.weapons.spells.HeavensHand;
import sheep.model.items.weapons.spells.HeavyShroud;
import sheep.model.items.weapons.spells.SandMan;

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
		Vehicle vehicle = new Boat(model, loc);
		map.add(loc, vehicle);
				
		//add river (first part)
		RiverCounter rc = new RiverCounter();
		Decal myDec;
		loc = new Location(16,6);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.SW,10,rc, myDec));
		loc = new Location(17,5);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.SW,10,rc, myDec));
		loc = new Location(18,5);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(18,4);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(18,3);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(18,2);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		
		rc = new RiverCounter();
		//river two 7,12
		loc = new Location(0,16);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.NE,10,rc, myDec));
		loc = new Location(0,15);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.S,10,rc, myDec));
		loc = new Location(1,14);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.SW,10,rc, myDec));
		loc = new Location(2,14);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.SW,10,rc, myDec));
		loc = new Location(3,13);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.SW,10,rc, myDec));
		loc = new Location(4,13);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.SW,10,rc, myDec));
		loc = new Location(5,12);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.SW,10,rc, myDec));
		loc = new Location(6,12);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.SW,10,rc, myDec));
		loc = new Location(7,11);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.SW,10,rc, myDec));
		loc = new Location(8,11);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SE,Direction.SW,10,rc, myDec));
		loc = new Location(9,11);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.NW,10,rc, myDec));
		loc = new Location(10,11);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.SW,10,rc, myDec));
		loc = new Location(10,12);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SE,Direction.N,10,rc, myDec));
		loc = new Location(11,12);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SE,Direction.NW,10,rc, myDec));
		loc = new Location(12,13);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.NW,10,rc, myDec));
		loc = new Location(12,14);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.N,10,rc, myDec));
		loc = new Location(12,15);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.N,10,rc, myDec));
		loc = new Location(11,15);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.NE,10,rc, myDec));
		loc = new Location(11,16);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.N,10,rc, myDec));
		loc = new Location(11,17);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.N,10,rc, myDec));
		loc = new Location(11,18);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.N,10,rc, myDec));
		loc = new Location(10,19);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.NE,10,rc, myDec));
		loc = new Location(10,20);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.N,10,rc, myDec));
		loc = new Location(9,20);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.NE,10,rc, myDec));
		loc = new Location(9,21);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.N,10,rc, myDec));
		loc = new Location(8,22);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.NE,10,rc, myDec));
		loc = new Location(7,22);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.NE,10,rc, myDec));
		loc = new Location(7,23);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.N,10,rc, myDec));
		loc = new Location(6,24);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.NE,10,rc, myDec));
		loc = new Location(5,24);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.NE,10,rc, myDec));
		loc = new Location(5,25);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.N,10,rc, myDec));
		loc = new Location(4,26);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.NE,10,rc, myDec));
		loc = new Location(3,26);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.NE,10,rc, myDec));
		loc = new Location(3,27);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.N,10,rc, myDec));
		loc = new Location(2,28);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.NE,10,rc, myDec));
		loc = new Location(1,28);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.NE,10,rc, myDec));
		loc = new Location(1,29);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.N,10,rc, myDec));
		loc = new Location(0,30);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.NE,10,rc, myDec));
		loc = new Location(0,29);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(0,28);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(0,27);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(0,26);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(0,25);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(0,24);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(0,23);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(0,22);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(0,21);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(0,20);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(0,19);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(0,18);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SE,Direction.S,10,rc, myDec));
		loc = new Location(1,18);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.NW,10,rc, myDec));
		loc = new Location(2,18);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SE,Direction.SW,10,rc, myDec));
		loc = new Location(3,18);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.NW,10,rc, myDec));
		loc = new Location(4,18);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SE,Direction.SW,10,rc, myDec));
		loc = new Location(5,18);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.NW,10,rc, myDec));
		loc = new Location(6,18);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SE,Direction.SW,10,rc, myDec));
		loc = new Location(7,18);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.NW,10,rc, myDec));
		loc = new Location(7,17);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(7,16);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NE,Direction.S,10,rc, myDec));
		loc = new Location(8,16);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.SW,10,rc, myDec));
		loc = new Location(8,15);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(8,14);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.N,Direction.S,10,rc, myDec));
		loc = new Location(8,13);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NW,Direction.S,10,rc, myDec));
		loc = new Location(7,12);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.SE,10,rc, myDec));
		loc = new Location(6,13);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.NE,10,rc, myDec));
		loc = new Location(5,13);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.NE,10,rc, myDec));
		loc = new Location(5,14);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.S,Direction.N,10,rc, myDec));
		loc = new Location(5,15);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NW,Direction.N,10,rc, myDec));
		loc = new Location(4,15);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.SE,10,rc, myDec));
		loc = new Location(3,15);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.NW,Direction.NE,10,rc, myDec));
		loc = new Location(2,15);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.SE,10,rc, myDec));
		loc = new Location(1,15);
		myDec = new Decal("arrow",model,loc);
		map.add(loc, myDec);
		map.add(loc,new River(model,loc,Direction.SW,Direction.NE,10,rc, myDec));
		loc = new Location(6,0);
		map.add(loc, new FlowReverser(model,loc,rc));
		
		//Weed Garden
		loc = new Location(2,37);
		map.add(loc, new Decal("weed", model, loc));
		loc = new Location(3,37);
		map.add(loc, new Decal("weed", model, loc));
		loc = new Location(4,36);
		map.add(loc, new Decal("weed", model, loc));
		loc = new Location(4,37);
		map.add(loc, new Decal("weed", model, loc));
		loc = new Location(5,36);
		map.add(loc, new Decal("weed", model, loc));
		loc = new Location(5,37);
		map.add(loc, new Decal("weed", model, loc));
		loc = new Location(6,36);
		map.add(loc, new Decal("weed", model, loc));
		loc = new Location(6,37);
		map.add(loc, new Decal("weed", model, loc));
		loc = new Location(7,36);
		map.add(loc, new Decal("weed", model, loc));
		loc = new Location(7,37);
		map.add(loc, new Decal("weed", model, loc));
		loc = new Location(8,36);
		map.add(loc, new AngrySpider(model, loc));
		loc = new Location(8,37);
		map.add(loc, new AngrySpider(model, loc));
		loc = new Location(8,35);
		map.add(loc, new AngrySpider(model, loc));
		loc = new Location(6,36);
		map.add(loc, new AngrySpider(model, loc));
		
		// Add wolves
		loc = new Location(6, 6);
		map.add(loc, new Spider(model, loc));
		loc = new Location(17, 14);
		map.add(loc, new AngrySpider(model, loc));

		loc = new Location(13, 14);
		AreMyRat r = new AreMyRat( model, loc );
		r.addToInventory( new GoldStaff(model, null) );
		map.add(loc, r);
		
		loc = new Location(13, 15);
		AreMyRat r2 = new AreMyRat( model, loc );
		r2.addToInventory( new GoldStaff(model, null) );
		map.add(loc, r2);
		
		loc = new Location(14, 15);
		AreMyRat r3 = new AreMyRat( model, loc );
		r3.addToInventory( new MarlinsCap(model, null) );
		map.add(loc, r3);
		
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
		loc = new Location(19, 9);
		map.add(loc, new Trap(model, loc,25));
		
		// Teleporter
		loc = new Location(18, 1);
		map.add(loc, new Teleport(model, loc, new Location(7, 13)));

		// Steel Wool Armor
		loc = new Location(5, 8);
		map.add(loc, new SteelWool(model, loc));
		loc = new Location(5, 9);
		map.add(loc,new Fire(model, loc));
		loc = new Location(4, 8);
		map.add(loc,new HeavensHand(model, loc));
		loc = new Location(4, 7);
		map.add(loc,new GaeasCradle(model, loc));
		loc = new Location(4, 6);
		map.add(loc,new HeavyShroud(model, loc));
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
		loc = new Location(2, 37);
		map.add(loc, new Key(model, loc, new Location(1,0)));
		
		//Weapons
		loc = new Location(8, 25);
		map.add(loc, new CrossBow(model, loc));
		
		loc = new Location(10, 25);
		map.add(loc, new FlareGun(model, loc));
		
		loc = new Location(12, 25);
		map.add(loc, new SpearGun(model, loc));
		
		loc = new Location(6, 27);
		map.add(loc, new ShortSword(model, loc));
		
		loc = new Location(8, 27);
		map.add(loc, new Hammer(model, loc));
		
		loc = new Location(10, 27);
		map.add(loc, new Nunchucks(model, loc));
		
		loc = new Location(12, 27);
		map.add(loc, new LongSword(model, loc));
		
		loc = new Location(14, 27);
		map.add(loc, new HeavyAxe(model, loc));
		
		loc = new Location(16, 27);
		map.add(loc, new Trident(model, loc));
		
		loc = new Location(8, 29);
		map.add(loc, new OakStaff(model, loc));
		
		loc = new Location(10, 29);
		map.add(loc, new AshStaff(model, loc));
		
		loc = new Location(12, 29);
		map.add(loc, new GoldStaff(model, loc));
		
		loc = new Location(8, 30);
		map.add(loc, new WheatThins(model, loc));
		
		loc = new Location(10, 30);
		map.add(loc, new WheatThins(model, loc));
		
		loc = new Location(12, 30);
		map.add(loc, new WheatThins(model, loc));
		
		loc = new Location(13,11);
		map.add(loc, new Mana(model, loc));
		
		loc = new Location(14,32);
		map.add(loc, new HappyMeal(model,loc));
		
		loc = new Location(9,6);
		map.add(loc, new HappyMeal(model,loc));
		
		loc = new Location(8, 31);
		map.add(loc, new OrangeJuice(model, loc));
		
		loc = new Location(10, 31);
		map.add(loc, new OrangeJuice(model, loc));
		
		loc = new Location(12, 31);
		map.add(loc, new OrangeJuice(model, loc));
		
		loc = new Location(0,0);
		PilotLicense p = new PilotLicense(model, loc);
		map.add(loc, p);
		
		loc = new Location (2,0);
		map.add(loc, new CalmAnimal(model,loc));
		
		loc = new Location (3,0);
		map.add(loc, new EnrageAnimal(model,loc));
		
		loc = new Location (4,0);
		map.add(loc, new SandMan(model,loc));
		
		loc = new Location(16, 30);
		map.add(loc, new Plane(model, loc, p));
		
		
		//Other Armor
		loc = new Location(20, 9);
		map.add(loc, new BikeHelmet(model, loc));
		
		loc = new Location(20, 10);
		map.add(loc, new BronzeWool(model, loc));
		
		loc = new Location(20, 11);
		map.add(loc, new CrossTrainers(model, loc));
		
		loc = new Location(18, 12);
		map.add(loc, new SheepSandals(model, loc));
		
		loc = new Location(19, 13);
		map.add(loc, new Shield(model, loc));
		
		loc = new Location(19, 14);
		map.add(loc, new SteelToedShoes(model, loc));
		
		
		
		//TPain
		loc = new Location( 9, 10 );
		TPBoat tpainBoat = new TPBoat(model, loc);
		map.add(loc, tpainBoat);
		TPayneAI tai = new TPayneAI(model,tpainBoat);
		Time.getInstance().removeObserver(tai);
		loc = new Location(15,0);
		NPC tPain = new TPayne(model, loc, tai);
		tpainBoat.setTPayne(tPain);
		tai.setMyNpc(tPain);
//		tpainBoat.setDriver( tPain );
		map.add( loc,  tPain );
		loc = new Location(10,4);
		map.add(loc, new FreeBoatRideFor3(model,loc,tai));
		
		
		return map;
	}

}
