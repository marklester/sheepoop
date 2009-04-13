package util;

import java.awt.Image;
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
	
	private static ResourceLoader instance = new ResourceLoader();
	private HashMap<String, String> fileMap;
	private HashMap<String, Image> imageMap;

	private static final String IMG_DIR = "res/imgs/";
	private static final String ICON_DIR = IMG_DIR +  "icons/";
	
	
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
		
		
		//Welcome Screen images
		imageMap.put("WelcomeScreenBG", getImage("WelcomeScreenBG"));
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