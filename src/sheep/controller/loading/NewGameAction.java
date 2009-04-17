package sheep.controller.loading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sheep.controller.Controller;
import sheep.model.Model;
import sheep.model.entities.Avatar;
import sheep.model.gamemap.GameMap;
import sheep.model.gamemap.Level1MapCreator;
import sheep.model.gamemap.Location;
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
		GameMap map = new Level1MapCreator().createMap(model);
		model.setMap(map);
		
		// Create avatar and set it in map
		Avatar avatar = new Avatar("Summoner", map, startingLoc, occupation, model);
		map.add(startingLoc, avatar);
		model.setAvatar(avatar);
		
		// Create view
		View view = new View(model);
		
		// Create controller
		new Controller(model, view);
		
		// Close welcome view
		this.welcomeView.dispose();
	}

}
