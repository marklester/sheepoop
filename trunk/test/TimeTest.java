import sheep.model.Time;
import sheep.model.TimeObserver;

/**
 * 
 * @author Phil Freo
 */
public class TimeTest {

	
	public static void main(String args[]) {
		
		final Time time = Time.getInstance();
		time.start();
		
		
		
		time.registerObserver(new TimeObserver() {
			private int numTicks = 0;

			@Override
			public void tick() {
				numTicks++;
				System.out.println("we got tick message " + numTicks);
				if (numTicks == 300) {
					time.pause();
				}
			}
			
		});
		
	}
	
}
