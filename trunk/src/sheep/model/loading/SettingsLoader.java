package sheep.model.loading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SettingsLoader {

	private File file;
	
	public SettingsLoader(File file) {
		this.file = file;
	}

	public KeySettings load() {
		
		KeySettings settings = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		
		try
		{
			fis = new FileInputStream(file);
			in = new ObjectInputStream(fis);
			settings = (KeySettings) in.readObject();
			in.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try {
				if(in != null)
					in.close();
			} catch (IOException e) { }
		}

		return settings;
	}
}