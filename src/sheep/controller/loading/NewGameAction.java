package sheep.controller.loading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sheep.controller.Controller;
import sheep.model.Model;
import sheep.model.entities.Avatar;
import sheep.model.entities.Vehicle;
import sheep.model.entities.npc.Wolf;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Location;
import sheep.model.gamemap.MapCreator;
import sheep.model.occupations.Occupation;
import sheep.model.occupations.Smasher;
import sheep.model.occupations.Sneak;
import sheep.model.occupations.Summoner;
import sheep.view.View;
import sheep.view.loading.WelcomeView;

/**
 * Creates a new game (by creating a new Model, View, Controller) and then 
 * closes the WelcomeView.
 * @author Phil Freo
 * @author Michael Cugini
 */
public class NewGameAction implements ActionListener {
	
	private static File mapFile = new File("res/maps/testmapone.txt");
	private Location startingLoc = new Location(8, 5);	// for Avatar
	private WelcomeView welcomeView;
	
	public NewGameAction(WelcomeView wv) {
		this.welcomeView = wv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		// Determine Occupation
		String command = e.getActionCommand();
		Occupation occupation = null;
		if( command.equals( WelcomeView.SMASHER) ) {
			occupation = new Smasher();
		} 
		else if( command.equals( WelcomeView.SUMMONER) ) {
			occupation = new Summoner();
		}
		else if( command.equals( WelcomeView.SNEAK) ) {
			occupation = new Sneak();
		} else {
			throw new RuntimeException("An invalid occupation was chosen");
		}
		
		// Create Model
		Model model = new Model();
		
		// Load game map and set in model
		GameMap map = null;
		try {
			map = MapCreator.createMap(mapFile);
		} catch (IOException err) {
			err.printStackTrace();
		}
		model.setMap(map);
		
		// Create avatar and set it in map
		Avatar avatar = new Avatar("Summoner", map, startingLoc, occupation);
		map.add(startingLoc, avatar);
		model.setAvatar(avatar);
		
		// Add other objects to map - TODO we should have a Level1MapGenerator.java that returns a gamemap instead of doing this stuff here
		Location loc;
		loc = new Location(9, 7);
		Vehicle vehicle = new Vehicle("Boat", map, loc, model);
		map.add(loc, vehicle);
		
		// Add wolfs
		List<Location> locations = new ArrayList<Location>();
		locations.add(new Location(6, 6));
		locations.add(new Location(8, 8));
		locations.add(new Location(10, 3));
		locations.add(new Location(12, 12));
		for (Location aLoc : locations) {
			map.add(aLoc, new Wolf(map, aLoc));
		}
		
		// Create view
		View view = new View(model);
		
		// Create controller
		new Controller(model, view);
		
		// Close welcome view
		this.welcomeView.dispose();
	}

}
