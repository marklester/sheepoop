package util;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import javax.imageio.ImageIO;


/**
 * Acts as a singleton. It has 2 maps, one that maps ID strings to filenames, and one that maps ID strings to 
 * Image files. 
 * 
 */

public class ResourceLoader {
	
	public static final String IMG_DIR = "res" + File.separator + "imgs";
	public static final String ICON_DIR = IMG_DIR + File.separator + "icons";

	private static ResourceLoader instance = new ResourceLoader();
	private HashMap<String, File> fileMap;
	private HashMap<String, Image> imageMap;

	
	
	/**
	 * This will be the central place to input any IO related filenames. The entire application should use this 
	 * class to access images. Any welcome screen images should be manually put into the imageMap in this 
	 * constructor
	 *  
	 */
	
	private ResourceLoader() {
		fileMap = new HashMap<String, File>();
		imageMap = new HashMap<String, Image>();
		fileMap.put("WelcomeScreenBG", new File( IMG_DIR, "mapbg.gif") );
		fileMap.put("newGame", new File( ICON_DIR, "newgame.png" ));
		fileMap.put("loadGame", new File( ICON_DIR,  "loadgame.png") );
		fileMap.put("quitGame", new File( ICON_DIR, "quitgame.png" ));
		fileMap.put("settings", new File(ICON_DIR, "settings.png") );
		fileMap.put("smasher", new File(ICON_DIR, "smasher.png") );
		fileMap.put("summoner", new File(ICON_DIR, "summoner.png") );
		fileMap.put("sneak", new File(ICON_DIR, "sneak.png") );
		
		//Welcome Screen images
		imageMap.put("WelcomeScreenBG", getImage("WelcomeScreenBG"));
		imageMap.put("newGame", getImage("newGame"));
		//imageMap.put("loadGame", getImage("loadGame"));
		//imageMap.put("quitGame", getImage("quitGame"));
		//imageMap.put("settings", getImage("settings"));
		
	}
	
	public static ResourceLoader getInstance() {
		return instance;
	}
	
	/**
	 * 
	 * @param id String id - all classes implementing Drawable will have an id
	 * @return Image that is mapped to that id.
	 */
	
	public Image getImage(String id) {
		Image img = imageMap.get(id);
		if (img == null) {
			try {
				img = ImageIO.read(getFileInputStream(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
			imageMap.put(id, img);
		}			
		return img;
	}
	
	public FileInputStream getFileInputStream(String id) throws FileNotFoundException {
		try {
			System.out.println(fileMap.get(id).getAbsolutePath());
			return new FileInputStream( fileMap.get(id).getAbsolutePath() );
		}
		catch(FileNotFoundException e) {
			System.out.println( id );
			throw new FileNotFoundException();
		}
	}
	
	public Image getBGImage() {
		return imageMap.get("WelcomeScreenBG");
	}
}