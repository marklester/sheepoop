package sheep.model.entities;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface SkillPointChangeObserver {
	
	public void update();

}
