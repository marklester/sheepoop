package sheep.view.util;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 * Acts as a singleton. It has 2 maps, one that maps ID strings to filenames, and one that maps ID strings to 
 * Image files. 
 * 
 */

public class ResourceLoader {
	
	private static ResourceLoader instance = new ResourceLoader();
	private HashMap<String, String> fileMap;
	private HashMap<String, Image> imageMap;

	private static final String IMG_DIR = "res/imgs/";
	private static final String ICON_DIR = IMG_DIR +  "icons/";
	private static final String TERRAIN_DIR = IMG_DIR + "terrains/";
	
	
	/**
	 * This will be the central place to input any IO related filenames. The entire application should use this 
	 * class to access images. Any welcome screen images should be manually put into the imageMap in this 
	 * constructor
	 *  
	 */
	
	
	private ResourceLoader() {
		fileMap = new HashMap<String, String>();
		imageMap = new HashMap<String, Image>();
		fileMap.put("WelcomeScreenBG", IMG_DIR + "mapbg.gif");
		fileMap.put("newGame", ICON_DIR + "newGame.png");
		fileMap.put("loadGame", ICON_DIR + "loadGame.png");
		fileMap.put("quitGame", ICON_DIR + "quitGame.png");
		fileMap.put("settings", ICON_DIR + "settings.png");
		fileMap.put("smasher", ICON_DIR + "smasher.png");
		fileMap.put("summoner", ICON_DIR + "summoner.png");
		fileMap.put("sneak", ICON_DIR + "sneak.png");
		fileMap.put("Water", TERRAIN_DIR + "water.png");
		fileMap.put("Grass", TERRAIN_DIR + "grass.png");
		fileMap.put("Mountain", TERRAIN_DIR + "mountains.png");
		
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
	
	public ImageIcon getImageIcon(String id) {
		return new ImageIcon( getImage(id) );
	}
	
	public FileInputStream getFileInputStream(String id) throws FileNotFoundException {
		try {
			String s = fileMap.get(id);
			return new FileInputStream(fileMap.get(id));
		}
		catch(FileNotFoundException e) {
			throw new FileNotFoundException();
		}
	}
	
	public Image getBGImage() {
		return imageMap.get("WelcomeScreenBG");
	}
}