package sheep.model.loading;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SettingsSaver {

	public static final File CUSTOM_SETTINGS = new File( "res/settings/customSettings.psettings" );
	
	public void save(KeySettings settings) {
		
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try
		{
			fos = new FileOutputStream( CUSTOM_SETTINGS );
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