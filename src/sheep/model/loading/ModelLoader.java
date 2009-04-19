package sheep.model.loading;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import sheep.model.Model;
import sheep.model.entities.Avatar;

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
			Avatar avatar = (Avatar) in.readObject();
			System.out.println(avatar);
			in.close();
			fis.close();
		}
		catch(EOFException ex) {
			System.out.println("eof exceptions");
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
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}

		if (model == null) {
			System.out.println("modelloader made a null model");
			System.exit(0);
		}
		
		System.out.println("look here:");
		System.out.println(model.getGameMap());
		System.out.println("look up");
		
		return model;
	}
}