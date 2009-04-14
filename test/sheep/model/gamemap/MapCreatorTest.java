package sheep.model.gamemap;

import java.io.File;
import java.io.IOException;

import sheep.model.Model;
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
		
		View view = new View(model);
		
	}
}