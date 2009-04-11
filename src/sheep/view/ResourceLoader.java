package sheep.view;

import java.awt.Image;
import java.io.File;
import java.util.Map;

public class ResourceLoader {
	
	private static ResourceLoader instance = new ResourceLoader();
	private Map<String, File> fileMap;
	private Map<String, Image> imageMap;

	private ResourceLoader() {
		
	}

	public static ResourceLoader getInstance() {
		return instance;
	}

	public Image getImage(String id) {
		throw new UnsupportedOperationException();
	}
}