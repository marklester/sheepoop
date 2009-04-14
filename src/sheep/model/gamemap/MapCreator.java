package sheep.model.gamemap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import sheep.model.terrains.Grass;
import sheep.model.terrains.Mountain;
import sheep.model.terrains.Water;

/**
 * 
 * @author Bryan Rosander
 */
public class MapCreator
{
	public static GameMap createMap(File pathAndName) throws IOException
	{
		GameMap myMap = new GameMap();
		
		FileReader fis = new FileReader(pathAndName);
		BufferedReader myReader = new BufferedReader(fis);
		
		String line = myReader.readLine();
		
		int y = 0;
		while(line!=null)
		{
			for(int i = 0; i < line.length(); i++)
			{
				Location myLoc = new Location(i,y);
				switch(line.charAt(i))
				{
				case 'G':
					myMap.add(myLoc, new Grass(myMap,myLoc));
					break;
				case 'W':
					myMap.add(myLoc, new Water(myMap,myLoc));
					break;
				case 'M':
					myMap.add(myLoc, new Mountain(myMap,myLoc));
					break;
				}
			}
			line = myReader.readLine();
			y++;
		}
		
		
		return myMap;
	}
}
