import java.awt.*; 
import java.awt.image.*; 
import javax.swing.*; 
import java.awt.Graphics2D; 


class hexmaptest{ 
	static private final int WIDTH = 800; 
	static private final int HEIGHT = 800; 
	public static void main( String[] args ) { 
		SwingUtilities.invokeLater( new Runnable() { 
			public void run(){ 
				createAndShowGUI(); 
			}	 
		} ); 
	} 
	private static void createAndShowGUI() { 
		// create the mouse panel 
		HexPanel panel = new HexPanel( WIDTH, HEIGHT ); 
		// create the frame to hold it 
		HexFrame frame = new HexFrame( panel ); 
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //<- BY default just hides the Frame
		// layout and display the GUI 
		frame.pack(); // no need to validate(); 
		frame.setVisible( true ); 
	} 
}
class HexFrame extends JFrame { 
	private static final long serialVersionUID = 1L;
	private final HexPanel panel; 
	public HexFrame( HexPanel panel ) { 
		this.panel = panel; 
		this.getContentPane().add( panel, BorderLayout.CENTER ); 
		this.setTitle( "Mark's Interpretation of the Game of Life" ); 
	} 
	
	
}

class HexPanel extends JPanel { 
	private static final long serialVersionUID = 1L;
	private BufferedImage image; 
	private Graphics2D g2d;
	 //pixel to cell ratio for height
	private final int WIDTH; 
	private final int HEIGHT; 
	private int tile_size = 20;
	public HexPanel( int width, int height) { 
		WIDTH = width; 
		HEIGHT = height; 
		Dimension dim = new Dimension( WIDTH, HEIGHT ); 
		this.setPreferredSize( dim );
			
		image = new BufferedImage( WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB ); 
		g2d = image.createGraphics(); 
		g2d.fillRect( 0, 0, WIDTH, HEIGHT );
		g2d.setColor(Color.BLACK);
		Point pt = new Point(0,0);
		double yf=((tile_size*Math.sqrt(3))/2);
		for(int i =0;i<(HEIGHT/tile_size);i++){
			if(i!=0)
				pt.y += (yf*2);
			for(int j=0;j<(WIDTH/tile_size);j++){
				double xf =j*(tile_size*1.5);
				if(j%2==0){
					//g2d.setColor(Color.BLUE);
					g2d.drawPolygon(this.createHexagon((int)(pt.getX()+xf), (int)(pt.getY())));
				}
				else{
					//g2d.setColor(Color.RED);
					g2d.drawPolygon(this.createHexagon((int)(pt.getX()+xf), (int)(pt.getY()+yf)));
				}
			}
			
			
		}
		
	} 
	Polygon createHexagon(int x,int y){
		Polygon p = new Polygon();
		for (int i = 0; i < 6; i++) {
			int vx = (int)(x + tile_size * Math.cos(i * 2 * Math.PI / 6));
			int vy = (int)(y + tile_size * Math.sin(i * 2 * Math.PI / 6));
			p.addPoint(vx,vy);
			//String point= "("+vx+","+vy+")";
			//g2d.drawChars(point.toCharArray(), 0, point.length(), vx, vy);
			//double xd = (vx-x)*(vx-x);
			//double yd = (vy-y)*(vy-y);
			//double d= xd+yd;
			//double dist = Math.sqrt(d);
			//System.out.printf("%f,",dist);
		}
		return p;
	}
	public void paintComponent( Graphics g ) { 
		super.paintComponent( g ); 
		g.drawImage( image, 0, 0, null ); 
	} 	
	
}
