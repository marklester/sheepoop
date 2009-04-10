package view;

public class ResourceLoader {
	private Map<id_String, file_File> fileMap;
	private Map<id_String, img_Image> imageMap;

	private ResourceLoader() {
		throw new UnsupportedOperationException();
	}

	public static view.ResourceLoader getInstance() {
		throw new UnsupportedOperationException();
	}

	public Image getImage(String id) {
		throw new UnsupportedOperationException();
	}
}