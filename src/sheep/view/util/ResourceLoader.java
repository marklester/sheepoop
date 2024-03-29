package sheep.view.util;

import java.awt.Font;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


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
//	private HashMap<String, InputStream> audioMap;

	private static final String IMG_DIR = "res/imgs/";
	private static final String ICON_DIR = IMG_DIR +  "icons/";
	private static final String TERRAIN_DIR = IMG_DIR + "terrains/";
	private static final String SPRITES_DIR = IMG_DIR + "sprites/";
	private static final String FONTS_DIR = "res/fonts/";
	private static final String ITEMS_DIR = IMG_DIR + "items/";
	private static final String DECALS_DIR = IMG_DIR+"decals/";
	private static final String WEAP_DIR = ITEMS_DIR + "weapons/";
	private static final String ONE_SHOT_DIR = ITEMS_DIR + "oneshot/";
	private static final String USEABLE_DIR = ITEMS_DIR + "useable/";
	private static final String INTERACTIVE_DIR = ITEMS_DIR + "interactive/";
	private static final String AUDIO_DIR = "res/music/";
	private final ClassLoader loader;
	
	private Player tPainPlayer;
	
	/**
	 * This will be the central place to input any IO related filenames. The entire application should use this 
	 * class to access images.
	 *  
	 */
	
	
	private ResourceLoader() {
		this.loader = getClass().getClassLoader();
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
		fileMap.put("addSkillPoint", ICON_DIR + "plus_sign.png");
		fileMap.put("OK", ICON_DIR + "ok.png");
		fileMap.put("Default", ICON_DIR + "default.png");
		fileMap.put("Cancel", ICON_DIR + "cancel.png");
		
		
		fileMap.put("Water", TERRAIN_DIR + "water2.gif");
		fileMap.put("Grass", TERRAIN_DIR + "grass.png");
		fileMap.put("Mountain", TERRAIN_DIR + "mountains2.png");
		fileMap.put("BlackTile", TERRAIN_DIR + "black.png");
		
		fileMap.put("Summoner", SPRITES_DIR + "sheep2.png");
		fileMap.put("Smasher", SPRITES_DIR + "sheep2.png");
		fileMap.put("Sneak", SPRITES_DIR + "sheep2.png");
		fileMap.put("statsFont", FONTS_DIR + "statsFont.ttf");
		fileMap.put("Boat", SPRITES_DIR + "boat1.gif");
		fileMap.put("Plane", SPRITES_DIR + "plane.png");
		fileMap.put("Spider", SPRITES_DIR+"spider.png");
		fileMap.put("AreMyRat", SPRITES_DIR+"rat.png");
		fileMap.put("TPain", SPRITES_DIR+"tpain.png");
		
		//Items
		fileMap.put("Boulder",ITEMS_DIR+ "boulder.png");
		fileMap.put("Steel Wool",ITEMS_DIR+ "armor/steelwool.png");
		fileMap.put("Bike Helmet",ITEMS_DIR+ "armor/bikehelmet.png");
		fileMap.put("Bronze Wool",ITEMS_DIR+ "armor/bronzewool.png");
		fileMap.put("Cross Trainers",ITEMS_DIR+ "armor/crosstrainers.png");
		fileMap.put("Iron Wool",ITEMS_DIR+ "armor/ironwool.png");
		fileMap.put("Marlins Cap",ITEMS_DIR+ "armor/marlincap.png");
		fileMap.put("Sheep Sandals",ITEMS_DIR+ "armor/sheepsandals.png");
		fileMap.put("Steel Toed Shoes",ITEMS_DIR+ "armor/steeltoedshoes.png");
		fileMap.put("Shield",ITEMS_DIR+ "armor/shield.png");
		
		
		//Decals
		fileMap.put("LevelUp", DECALS_DIR+"levelup.png");
		fileMap.put("HealDamage", DECALS_DIR+"healdamage.png");
		fileMap.put("TakeDamage", DECALS_DIR+"takedamage.png");
		fileMap.put("Trap", DECALS_DIR + "trap.png");
		fileMap.put("narrow", DECALS_DIR + "narrow.png");
		fileMap.put("nearrow", DECALS_DIR + "nearrow.png");
		fileMap.put("nwarrow", DECALS_DIR + "nwarrow.png");
		fileMap.put("sarrow", DECALS_DIR + "sarrow.png");
		fileMap.put("searrow", DECALS_DIR + "searrow.png");
		fileMap.put("swarrow", DECALS_DIR + "swarrow.png");
		fileMap.put("arrow", DECALS_DIR + "arrow.png");
		fileMap.put("weed", DECALS_DIR + "weed.png");
		
		//Weapons
		fileMap.put("Crossbow", WEAP_DIR + "xbow.png");
		fileMap.put("xbowbolt", WEAP_DIR+"xbowbolt.png");
		fileMap.put("Lightning", WEAP_DIR + "lightning.png");
		fileMap.put("Fire", WEAP_DIR + "fire.png");
		fileMap.put("HeavensHand", WEAP_DIR + "heavenshand.png");
		fileMap.put("HeavensHandEffect", WEAP_DIR + "heavenshandeffect.png");
		fileMap.put("GaeasCradle", WEAP_DIR + "gaeascradle.png");
		fileMap.put("GaeasCradleEffect", WEAP_DIR + "gaeascradleeffect.png");
		fileMap.put("HeavyShroud", WEAP_DIR + "heavyshroud.png");
		fileMap.put("HeavyShroudEffect", WEAP_DIR + "heavyshroudeffect.png");
		fileMap.put("Ice", WEAP_DIR + "ice.png");
		fileMap.put("Flare Gun", WEAP_DIR + "flaregun.png");
		fileMap.put("flare", WEAP_DIR+"flare.png");
		//Boons
		fileMap.put("Calm Animal", WEAP_DIR + "charmanimal.png");
		fileMap.put("Enrage Animal", WEAP_DIR + "enrageanimal.png");
		fileMap.put("Sand Man", WEAP_DIR + "sandman.png");
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
		fileMap.put("Fist", WEAP_DIR + "brawling.png");
		//one shots
		fileMap.put("Syringe", ONE_SHOT_DIR + "speed.png");
		fileMap.put("Beer", ONE_SHOT_DIR + "beer.png");
		fileMap.put("Key", ONE_SHOT_DIR + "key.png");
		//trap
		fileMap.put("Hidden Trap", ITEMS_DIR+"hidden.png");
		fileMap.put("Activated Trap", ITEMS_DIR+"activatedtrap.png");
		fileMap.put("Detected Trap", ITEMS_DIR+"detectedtrap.png");
		
		//useable
		fileMap.put("Wheat Thins", USEABLE_DIR + "wheatthins.png");
		fileMap.put("Mana", USEABLE_DIR + "mana.png");
		fileMap.put("Happy Meal", USEABLE_DIR + "happymeal.png");
		fileMap.put("Orange Juice", USEABLE_DIR + "orangejuice.png");
		
		//interactive
		fileMap.put("Pilot License", INTERACTIVE_DIR + "pilotlicense.png");
		fileMap.put("Flow Reverser",INTERACTIVE_DIR+"flowreverser.png");
		fileMap.put("Free boat", INTERACTIVE_DIR + "freeboatride.png");
		
		//tPain Audio
		fileMap.put("tpain", AUDIO_DIR + "on3.mp3");
		try {
			try {
				tPainPlayer = new Player( new BufferedInputStream( getAudioInputStream("tpain") ) );
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
		
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
	
	public InputStream getAudioInputStream(String key) throws FileNotFoundException {
		String filename = fileMap.get(key);
		if (filename != null)
			return new FileInputStream("res/music/on3.mp3");
		else
			return null;
	}
	
	public Player getTPainPlayer() {
		return tPainPlayer;
	}
}