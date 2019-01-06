package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;

/*
 * This is a God class and is doing way too much. The instance variables cover everything from isometric to 
 * Cartesian drawing and the class has methods for loading images and converting from one coordinate space to
 * another.
 * 
 */
public class GameView extends JPanel implements ActionListener, KeyListener { 
	private static final long serialVersionUID = 777L;
	
	//Encapsulate the things that vary...
	public static final int DEFAULT_VIEW_SIZE = 1280;
	//private Sprite p1;
	private Sprite player;

	//Do we really need two models like this?
	//MVC
	private int[][] matrix;
	private int[][] things;
	
	private BufferedImage[] tiles; //Note that all images, including sprites, have dimensions of 128 x 64. This make painting much simpler.
	private BufferedImage[] objects; //Taller sprites can be created, by using two tiles (head torso, lower body and legs) and improve animations
	
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
		player = SpriteFactory.getCharacter("Player 1", new PointHandler(0, 0), s.loadImages("./resources/images/sprites/person", null));
		//p1 = new Sprite("p1 1", new PointHandler(0, 0), false, false, s.loadImages("./resources/images/sprites/person", null));
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
		
		LevelPainter painter = new LevelPainter(g2, matrix, things, isIsometric, tiles, objects);
		
		paintp1(g2, isIsometric);
		
		pickupCheck(g2);
	}
	
	private void pickupCheck(Graphics2D g2) {
		if(player.getBoots() == true) {
			g2.drawString("Picked Up Boots of Water Walking!", 10, 10);
		}
		
		if(player.getKey() == true) {
			g2.drawString("Picked Up Key", 10, 50);
		}
		
		if(player.getSign() == true) {
			g2.drawString("The Sign Reads: You must drink from the fountain to unlock your way", 900, 10);
		}
		
		if(player.getCup() == true) {
			g2.drawString("You have a refreshing cup of lemonade! You now own a cup!", 10, 30);
		}
	}
	
	private void paintp1(Graphics2D g2, boolean isIso) {
		PointHandler point;
		Point ph = new PointHandler(0, 0);
				
		if(isIsometric) {
			ph = ph.getPoint(player.getPosition().getX(), player.getPosition().getY(), isIsometric);
			//System.out.println(ph.toString());
			point = (PointHandler) ph;
			g2.drawImage(player.getImage(), point.getX(), point.getY(), null);
			//g2.drawImage(p1.getImage(), point.getX(), point.getY(), null);
		}
		else {
			ph = ph.getPoint(player.getPosition().getX(), player.getPosition().getY(), isIsometric);
			point = (PointHandler) ph;
			//point = getCart(p1.getPosition().getX(), p1.getPosition().getY());
			g2.drawImage(player.getImage(), point.getX(), point.getY(), null);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setDirection(Direction.RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setDirection(Direction.LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.setDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setDirection(Direction.DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_Z) {
			toggleView();
		} else if (e.getKeyCode() == KeyEvent.VK_X) {
			player.move();
		} else if (e.getKeyCode() == KeyEvent.VK_C) {
			player.pickup();
		} else {
			return;
		}
	}
	
	public void keyReleased(KeyEvent e) {
	} // Ignore
	
	public void keyTyped(KeyEvent e) {
	} // Ignore
}