package sheep.view.util;

import java.awt.Font;
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
	private HashMap<String, Font> fontMap;

	private static final String IMG_DIR = "res/imgs/";
	private static final String ICON_DIR = IMG_DIR +  "icons/";
	private static final String TERRAIN_DIR = IMG_DIR + "terrains/";
	private static final String SPRITES_DIR = IMG_DIR + "sprites/";
	private static final String FONTS_DIR = "res/fonts/";
	private static final String ITEMS_DIR = IMG_DIR + "items/";
	private static final String DECALS_DIR = IMG_DIR+"decals/";
	private static final String WEAP_DIR = ITEMS_DIR + "weapons/";
	private static final String ONE_SHOT_DIR = ITEMS_DIR + "oneshot/";
	/**
	 * This will be the central place to input any IO related filenames. The entire application should use this 
	 * class to access images. Any welcome screen images should be manually put into the imageMap in this 
	 * constructor
	 *  
	 */
	
	
	private ResourceLoader() {
		fileMap = new HashMap<String, String>();
		imageMap = new HashMap<String, Image>();
		fontMap = new HashMap<String, Font>();
		fileMap.put("placeHolder", ICON_DIR + "placeHolder.png");
		fileMap.put("WelcomeScreenBG", IMG_DIR + "mapbg.gif");
		fileMap.put("sideBarBG", IMG_DIR + "sideBarBG.png");
		fileMap.put("newGame", ICON_DIR + "newgame.png");
		fileMap.put("loadGame", ICON_DIR + "loadgame.png");
		fileMap.put("quitGame", ICON_DIR + "quitgame.png");
		fileMap.put("settings", ICON_DIR + "settings.png");
		fileMap.put("smasherBtn", ICON_DIR + "smasher.png");
		fileMap.put("summonerBtn", ICON_DIR + "summoner.png");
		fileMap.put("sneakBtn", ICON_DIR + "sneak.png");
		fileMap.put("invPlaceHolder", ICON_DIR + "placeHolder.png");
		
		fileMap.put("Water", TERRAIN_DIR + "water2.gif");
		fileMap.put("Grass", TERRAIN_DIR + "grass.png");
		fileMap.put("Mountain", TERRAIN_DIR + "mountains2.png");
		fileMap.put("BlackTile", TERRAIN_DIR + "black.png");
		
		fileMap.put("Summoner", SPRITES_DIR + "sheep1.gif");
		fileMap.put("Smasher", SPRITES_DIR + "sheep1.gif");
		fileMap.put("Sneak", SPRITES_DIR + "sheep1.gif");
		fileMap.put("statsFont", FONTS_DIR + "statsFont.ttf");
		fileMap.put("Boat", SPRITES_DIR + "boat1.gif");
		fileMap.put("Plane", SPRITES_DIR + "plane.png");
		fileMap.put("Wolf", SPRITES_DIR+"wolf.png");
		
		//Items
		fileMap.put("Boulder",ITEMS_DIR+ "boulder.png");
		fileMap.put("Steel Wool",ITEMS_DIR+ "armor/steelwool.png");
		
		//Decals
		fileMap.put("LevelUp", DECALS_DIR+"levelup.png");
		fileMap.put("HealDamage", DECALS_DIR+"healdamage.png");
		fileMap.put("TakeDamage", DECALS_DIR+"takedamage.png");
		fileMap.put("Trap", DECALS_DIR + "trap.png");
		
		//Weapons
		fileMap.put("Crossbow", WEAP_DIR + "xbow.png");
		fileMap.put("xbowbolt", WEAP_DIR+"xbowbolt.png");
		fileMap.put("Lightning", WEAP_DIR + "lightning.png");
		fileMap.put("Fire", WEAP_DIR + "fire.png");
		fileMap.put("Ice", WEAP_DIR + "ice.png");
		fileMap.put("Flare Gun", WEAP_DIR + "flaregun.png");
		fileMap.put("flare", WEAP_DIR+"flare.png");
		fileMap.put("Spear Gun", WEAP_DIR + "speargun.png");
		fileMap.put("spear", WEAP_DIR + "spear.png");
		fileMap.put("Heavy Axe", WEAP_DIR + "heavyaxe.png");
		fileMap.put("Long Sword", WEAP_DIR + "longsword.png");
		fileMap.put("Trident", WEAP_DIR + "trident.png");
		fileMap.put("Short Sword", WEAP_DIR + "shortsword.png");
		fileMap.put("Nunchucks", WEAP_DIR + "nunchucks.png");
		fileMap.put("Hammer", WEAP_DIR + "hammer.png");
		fileMap.put("Gold Staff", WEAP_DIR + "goldstaff.png");
		fileMap.put("Ash Staff", WEAP_DIR + "ashstaff.png");
		fileMap.put("Oak Staff", WEAP_DIR + "oakstaff.png");
		//one shots
		fileMap.put("Syringe", ONE_SHOT_DIR + "speed.png");
		fileMap.put("Beer", ONE_SHOT_DIR + "beer.png");
		fileMap.put("Key", ONE_SHOT_DIR + "key.png");
		//trap
		fileMap.put("Hidden Trap", ITEMS_DIR+"hidden.png");
		fileMap.put("Activated Trap", ITEMS_DIR+"activatedtrap.png");
		fileMap.put("Detected Trap", ITEMS_DIR+"detectedtrap.png");
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
				img = getImage("placeHolder");
			}
			imageMap.put(id, img);
		}			
		return img;
	}
	
	public ImageIcon getImageIcon(String id) {
		Image img = getImage(id);
		if (img == null)
			return null;
		return new ImageIcon( img );
	}
	
	public FileInputStream getFileInputStream(String id) throws FileNotFoundException {
		String file = fileMap.get(id);
		return new FileInputStream(file);
	}
	
	//We could add the ability to get other fonts later. For now, just get the single font
	public Font getFont(String key) {
		Font f = fontMap.get(key);
		try {
			if (f == null) {
				f = Font.createFont(Font.TRUETYPE_FONT, getFileInputStream(key));
				fontMap.put(key, f);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return Font.getFont(Font.SANS_SERIF);
		}
		return f;
	}
}