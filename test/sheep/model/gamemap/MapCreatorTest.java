package sheep.model.gamemap;

import java.io.File;
import java.io.IOException;

import sheep.model.Model;
import sheep.model.entities.Avatar;
import sheep.model.occupations.Summoner;
import sheep.view.View;

public class MapCreatorTest {

	public static void main(String args[]) {
		
		Model model = new Model();
		
		// Load game map and set in model
		GameMap map = null;
		try {
			map = MapCreator.createMap(new File("res/maps/testmapone.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.setMap(map);
		
		// test avatar
		Location startingLoc = new Location(8, 5);
		Avatar avatar = new Avatar("Summoner", map, startingLoc, new Summoner());
		map.add(startingLoc, avatar);
		model.setAvatar(avatar);
		
		View view = new View(model);
		
	}
}