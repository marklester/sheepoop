package sheep.model.loading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import sheep.model.Model;

public class ModelLoader {

	private File file;
	
	public ModelLoader(File file) {
		this.file = file;
	}

	public Model load() {
		Model model = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		
		try
		{
			fis = new FileInputStream(file);
			in = new ObjectInputStream(fis);
			model = (Model) in.readObject();
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

		return model;
	}
}