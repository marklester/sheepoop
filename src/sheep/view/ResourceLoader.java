package sheep.view;

import java.awt.Image;
import java.io.File;
import java.util.Map;

public class ResourceLoader {
	private Map<String, File> fileMap;
	private Map<String, Image> imageMap;

	private ResourceLoader() {
		throw new UnsupportedOperationException();
	}

	public static ResourceLoader getInstance() {
		throw new UnsupportedOperationException();
	}

	public Image getImage(String id) {
		throw new UnsupportedOperationException();
	}
}