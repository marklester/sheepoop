package sheep.model.loading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SettingsLoader {

	public static final File CUSTOM_SETTINGS = new File( "res/settings/customSettings.psettings" );
	public static final File DEFAULT_SETTINGS = new File( "res/settings/defaultSettings.psettings" );

	public KeySettings load() {

		if( CUSTOM_SETTINGS.exists() )
			return load( CUSTOM_SETTINGS );
		else
			return load( DEFAULT_SETTINGS );

	}
	
	private KeySettings load( File file )
	{
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
	
	public KeySettings loadDefault()
	{
		return load( DEFAULT_SETTINGS );
	}
}