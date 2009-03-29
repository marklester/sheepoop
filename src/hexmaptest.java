import java.awt.*; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
class HexFrame extends JFrame implements KeyListener{ 
	private static final long serialVersionUID = 1L;
	private final HexPanel panel; 
	public HexFrame( HexPanel panel ) { 
		this.panel = panel; 
		this.getContentPane().add( panel, BorderLayout.CENTER ); 
		this.setTitle( "Mark's Interpretation of the Game of Life" );
		addKeyListener(this);
	} 
	
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_NUMPAD2://down
				panel.getMap().movePlayer(0, 1);
			break;
			case KeyEvent.VK_NUMPAD8:
				panel.getMap().movePlayer(0, -1); //up
			break;
			case KeyEvent.VK_NUMPAD7://leftup
				panel.getMap().movePlayer(-1,-1);
			break;
			case KeyEvent.VK_NUMPAD9://rightup
				panel.getMap().movePlayer(1, -1);
			break;
			case KeyEvent.VK_NUMPAD1://downleft
				panel.getMap().movePlayer(-1,1);
			break;
			case KeyEvent.VK_NUMPAD3: //down right
				panel.getMap().movePlayer(1, 1);
			break;
			default:
			break;
		}
		panel.drawMap();
		//System.out.print("KeyPressed");
		repaint();
	}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {} 	
}

class HexPanel extends JPanel { 
	private static final long serialVersionUID = 1L;
	private Map map;
	private BufferedImage image; 
	private Graphics2D g2d;
	 //pixel to cell ratio for height
	private final int WIDTH; 
	private final int HEIGHT;
	private int maxr;
	private int maxc;
	private int tile_size = 50;
	public HexPanel( int width, int height) { 
		map = new Map(100,100);
		WIDTH = width; 
		HEIGHT = height;
		maxr = (int)(HEIGHT/(tile_size*1.25));;
		maxc = (int)(WIDTH/(tile_size*1.25));
		Dimension dim = new Dimension( WIDTH, HEIGHT ); 
		this.setPreferredSize( dim );
		image = new BufferedImage( WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB ); 
		g2d = image.createGraphics(); 
		g2d.fillRect( 0, 0, WIDTH, HEIGHT );
		g2d.setColor(Color.BLACK);
		drawMap();
	}
	public void drawMap(){
		g2d.fillRect( 0, 0, WIDTH, HEIGHT );
		Tile[][] tiles = map.getViewPort(maxr);
		Point pt = new Point(0,0);
		double yf=((tile_size*Math.sqrt(3))/2);
		for(int i =0;i<maxr;i++){
			if(i!=0)
				pt.y += (yf*2);
			for(int j=0;j<maxc;j++){
				double xf =j*(tile_size*1.5);
				Polygon hex;
				if(j%2==0)//stagger hex tiles so they fit together
					hex = createHexagon((int)(pt.getX()+xf), (int)(pt.getY()));
				else
					hex = createHexagon((int)(pt.getX()+xf), (int)(pt.getY()+yf));
				try{
					Color prev = g2d.getColor();
					int cx = i;
					int cy = j;
					if(tiles[cx][cy].getTerrain()==0){
						g2d.setColor(Color.BLUE);
						g2d.drawPolygon(hex);
					}
					else if(tiles[cx][cy].getTerrain()==1){
						g2d.setColor(Color.RED);
						g2d.fillPolygon(hex);
					}
					else if(tiles[cx][cy].getTerrain()==-1){
						g2d.setColor(Color.GRAY);
						g2d.fillPolygon(hex);
					}
					g2d.setColor(prev);
				}catch(Exception e){
					g2d.setColor(Color.YELLOW);
					g2d.drawPolygon(hex);
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
		drawMap();
		super.paintComponent( g ); 
		g.drawImage( image, 0, 0, null ); 
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}

	
}
class Map{
	private Tile[][] tiles;
	private Position player;
	public Map(int rows,int columns){
		tiles = new Tile[rows][columns];
		player = new Position(0,0);
		for(int i=0;i<tiles.length;i++){
			for(int j=0;j<tiles.length;j++){
				tiles[i][j]= new Tile(0);
			}
		}
		tiles[player.y][player.x].setTerrain(1);
	}
	public Tile[][] getViewPort(int size){//must be odd
		if(size%2==0)size++;
		int offset = (int)((size-1)/2);
		int starty = player.getY()-offset;
		int startx = player.getX()-offset;
		int endy = player.getY() +(size-offset);
		int endx = player.getX() +(size-offset);
		Tile[][] viewport = new Tile[size][size];
		int viewporty =0;
		int viewportx =0;
		for(int i = starty;viewporty<size;i++){
			//System.out.printf("(%d,%d)",viewportx,viewporty);
			for(int j = startx;viewportx<size;j++){
				try{
					viewport[viewporty][viewportx] = (Tile)tiles[i][j].clone();
				}catch(Exception e){
					viewport[viewporty][viewportx] = new Tile();
				}
				viewportx++;
			}
			viewportx=0;
			viewporty++;
		}
		return viewport;
	}
	public void movePlayer(int x,int y){
		//i - > y in cartesian plane so x is actually y and y is actually x
		if(player.x+x>=tiles.length || player.x+x<0 ||
				player.y+y>=tiles[0].length || player.y+y<0){
			
		}else{
			if(player.x%2==0){
				if(x==-1 && y==1){//fix 1
					y = 0;
				}
				else if(x==1 && y==1){//fix 3
					y = 0;
				}
			}else{
				if(x==-1 && y==-1){//fix 7
					y = 0;
				}
				else if(x==1 && y==-1){//fix 9
					y = 0;
				}
			}
			tiles[player.y][player.x].setTerrain(0);
			player.x = player.x+x;
			player.y = player.y+y;
			tiles[player.y][player.x].setTerrain(1);
			
		}
	}
	public Position getPlayer() {
		return player;
	}
	public void setPlayer(Position player) {
		this.player = player;
	}
	
}
class Tile implements Cloneable{
	private int terrain;
	public Tile(){
		terrain = -1;
	}
	public Tile(int terrain){
		this.terrain = terrain;
	}
	public Tile clone(){
		return new Tile(terrain);
	}
	public int getTerrain() {
		return terrain;
	}
	public void setTerrain(int terrain) {
		this.terrain = terrain;
	}

}
class Position{
	int x;
	int y;
	public Position(int x,int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}