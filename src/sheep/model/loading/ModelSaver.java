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
		try {
			fos = new FileOutputStream(file);
			out = new ObjectOutputStream(fos);
//			
//			DebuggingObjectOutputStream out = new DebuggingObjectOutputStream(fos);
//			try {
//			  
//				out.writeObject(model.getAvatar().getLocation());
//			  System.out.println(model);
//			  
//			} catch (Exception e) {
//			  throw new RuntimeException(
//			      "Serialization error. Path to bad object: " 
//			          + out.getStack(), e);
//			}
//			
			System.out.println(model);
			System.out.println(model);
			
			out.writeObject(model.getAvatar());
			out.close();
			fos.close();

		} catch (IOException ex) {
			ex.printStackTrace();
//
//			if (out != null)
//				try {
//					out.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}

		}
		
	}
}