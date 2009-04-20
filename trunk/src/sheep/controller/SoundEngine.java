package sheep.controller;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javazoom.jl.player.Player;
import sheep.view.util.ResourceLoader;


public class SoundEngine extends Thread {
	
	private Player player;
	private String key;
	
	private SoundEngine() {
		super();
	}
	
	private static SoundEngine getInstance() {
		//returns a new instance each time
		SoundEngine instance = new SoundEngine();
		return instance;
	}
	
	public static SoundEngine getInstance(String key) {
		//returns a new instance each time
		SoundEngine instance = getInstance();
		instance.setKey(key);
		return instance;
	}
	
	public void setKey(String k) {
		this.key = k;
	}
	
	@Override
	public void run() {
		playAudio(key);
	}
	
	
	public void playAudio(String key) {
		InputStream is;
		if (key.equals("tpain"))
			is = ResourceLoader.getInstance().getTPainStream();
		else 
			is = ResourceLoader.getInstance().getAudioInputStream("tpain");
		try {
            BufferedInputStream bis = new BufferedInputStream(is);
            player = new Player(bis);
            player.play();
		}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
		
	}

}
