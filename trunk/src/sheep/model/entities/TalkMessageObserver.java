package sheep.model.entities;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public interface TalkMessageObserver {

	public void update(TalkMessage msg);

}
