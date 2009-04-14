package sheep.model.loading;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SettingsSaver {

	private File file;
	
	public SettingsSaver(File file) {
		this.file = file;
	}

	public void save(JFrame frame) {
		
		JPanel pane = (JPanel) frame.getContentPane();
		
		KeySettings settings = new KeySettings( pane.getInputMap(), pane.getActionMap() );
	
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