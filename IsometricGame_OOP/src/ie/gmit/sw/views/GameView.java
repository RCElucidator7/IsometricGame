package ie.gmit.sw.views;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;

import ie.gmit.sw.Setup;
import ie.gmit.sw.SetupImplementor;
import ie.gmit.sw.builder.*;
import ie.gmit.sw.models.*;
import ie.gmit.sw.models.Point;

/*
 * This is a God class and is doing way too much. The instance variables cover everything from isometric to 
 * Cartesian drawing and the class has methods for loading images and converting from one coordinate space to
 * another.
 * 
 */
public class GameView extends JPanel implements ActionListener, KeyListener { 
	private static final long serialVersionUID = 777L;
	private static final int DEFAULT_IMAGE_INDEX = 0;
	
	//Encapsulate the things that vary...
	public static final int DEFAULT_VIEW_SIZE = 1280;
	private static final int TILE_WIDTH = 128;
	private static final int TILE_HEIGHT = 64;
	//private Sprite p1;
	private Sprite p1;

	//Do we really need two models like this?
	//MVC
	private int[][] matrix;
	private int[][] things;
	
	private BufferedImage[] tiles; //Note that all images, including sprites, have dimensions of 128 x 64. This make painting much simpler.
	private BufferedImage[] objects; //Taller sprites can be created, by using two tiles (head torso, lower body and legs) and improve animations
	private Color[] cartesian = {Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW, Color.PINK, Color.BLACK}; //This is a 2D representation
	
	private Timer timer; //Controls the repaint interval.
	private boolean isIsometric = true; //Toggle between 2D and Isometric (Z key)
	
	private Level lb = new LevelBuilder();
	
	public GameView(int[][] things) throws Exception {
		init();
		this.things = things;
		
		this.matrix = lb.setGround();
		
		setBackground(Color.WHITE);
		setDoubleBuffered(true); //Each image is buffered twice to avoid tearing / stutter
		JOptionPane.showMessageDialog(null,
				"Control the character by using the Arrow keys\n Press X to advance a tile and C to interact with an object", "Rules",
				JOptionPane.DEFAULT_OPTION);
		timer = new Timer(100, this); //calls the actionPerformed() method every 100ms
		timer.start(); //Start the timer
	}
	
	private void init() throws Exception {
		Setup s = new SetupImplementor();
		tiles = s.loadImages("./resources/images/ground", tiles);
		objects = s.loadImages("./resources/images/objects", objects);
		p1 = SpriteFactory.getCharacter("Player 1", new PointHandler(0, 0), false, false, s.loadImages("./resources/images/sprites/person", null));
		//p1 = new Sprite("p1 1", new PointHandler(0, 0), false, false, s.loadImages("./resources/images/sprites/person", null));
	}
	
	private void painter(Graphics2D g2) {
		
		Point ph1 = new PointHandler(0, 0);
		
		int imageIndex = -1, x1 = 0, y1 = 0;
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				imageIndex = matrix[row][col];
				
				if (imageIndex >= 0 && imageIndex < tiles.length) {
					//Paint the ground tiles
					if (isIsometric) {
						x1 = ph1.getIsoX(col, row);
						y1 = ph1.getIsoY(col, row);
						
						g2.drawImage(tiles[DEFAULT_IMAGE_INDEX], x1, y1, null);
						if (imageIndex > DEFAULT_IMAGE_INDEX) {
							g2.drawImage(tiles[imageIndex], x1, y1, null);
						}
					} else {
						x1 = col * TILE_WIDTH;
						y1 = row * TILE_HEIGHT;
	        			if (imageIndex < cartesian.length) {
	        				g2.setColor(cartesian[imageIndex]);
	        			}else {
	        				g2.setColor(Color.WHITE);
	        			}
						
	        			g2.fillRect(x1, y1, TILE_WIDTH, TILE_WIDTH);
					}
					//Paint the object or things on the ground
					imageIndex = things[row][col];
					g2.drawImage(objects[imageIndex], x1, y1, null);
				}
			}
		}
		
	}

	public void toggleView() {
		isIsometric = !isIsometric;
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) { //This is called each time the timer reaches zero
		this.repaint();
	}

	public void paintComponent(Graphics g) { //This method needs to execute quickly...
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		painter(g2);
		
		paintp1(g2, isIsometric);
		
		if(p1.getPickup() == true) {
			g2.drawString("Picked Up Boots of Water Walking!", 10, 10);
		}
		
		if(p1.getKey() == true) {
			g2.drawString("Picked Up Key", 10, 30);
		}
		
		if(p1.getSign() == true) {
			g2.drawString("The Sign Reads: You must drink from the fountain to unlock your way", 900, 10);
		}
	}
	
	private void paintp1(Graphics2D g2, boolean isIso) {
		PointHandler point;
		Point ph = new PointHandler(0, 0);
				
		if(isIsometric) {
			ph = ph.getPoint(p1.getPosition().getX(), p1.getPosition().getY(), isIsometric);
			//System.out.println(ph.toString());
			point = (PointHandler) ph;
			g2.drawImage(p1.getImage(), point.getX(), point.getY(), null);
			//g2.drawImage(p1.getImage(), point.getX(), point.getY(), null);
		}
		else {
			ph = ph.getPoint(p1.getPosition().getX(), p1.getPosition().getY(), isIsometric);
			point = (PointHandler) ph;
			//point = getCart(p1.getPosition().getX(), p1.getPosition().getY());
			g2.drawImage(p1.getImage(), point.getX(), point.getY(), null);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			p1.setDirection(Direction.RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			p1.setDirection(Direction.LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDirection(Direction.DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_Z) {
			toggleView();
		} else if (e.getKeyCode() == KeyEvent.VK_X) {
			p1.move();
		} else if (e.getKeyCode() == KeyEvent.VK_C) {
			p1.pickup();
		} else {
			return;
		}
	}
	
	public void keyReleased(KeyEvent e) {
	} // Ignore
	
	public void keyTyped(KeyEvent e) {
	} // Ignore
}