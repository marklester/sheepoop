package sheep.model.loading;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SettingsSaver {

	private File file;
	
	public SettingsSaver(File file) {
		this.file = file;
	}

	public void save(KeySettings settings) {
		
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try
		{
			fos = new FileOutputStream(file);
			out = new ObjectOutputStream(fos);
			out.writeObject(settings);
			out.close();
		}
		catch(IOException ex)
		{
			try {
				if(out != null)
					out.close();
			} catch (IOException e) { }
		}
	}
}