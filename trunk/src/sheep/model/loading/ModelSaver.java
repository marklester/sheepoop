package sheep.model.loading;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import sheep.model.Model;

public class ModelSaver {

	private File file;
	
	public ModelSaver(File file) {
		this.file = file;
	}

	public void save(Model model) {

		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try
		{
			fos = new FileOutputStream(file);
			out = new ObjectOutputStream(fos);
			out.writeObject(model);
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