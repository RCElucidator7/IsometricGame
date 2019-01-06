package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;

/*
 * GameView class that handles the drawing of the game and some mechanics
 * 
 */
public class GameView extends JPanel implements ActionListener, KeyListener { 
	private static final long serialVersionUID = 777L;
	
	public static final int DEFAULT_VIEW_SIZE = 1280;
	//private Sprite Player;
	private Sprite player;

	private int[][] matrix;
	private int[][] things;
	
	private BufferedImage[] tiles; //Note that all images, including sprites, have dimensions of 128 x 64. This make painting much simpler.
	private BufferedImage[] objects; //Taller sprites can be created, by using two tiles (head torso, lower body and legs) and improve animations
	
	private Timer timer; //Controls the repaint interval.
	private boolean isIsometric = true; //Toggle between 2D and Isometric (Z key)
	private boolean gameOver = false; //Check if the game is complete or not
	private boolean waterWalk = false; //Check if the character can walk on the water tiles or not

	//Initalize builders to build the 2D arrays of image values
	private Level lb = new LevelBuilder();
	private Level ob = new ObjectBuilder();
	
	public GameView() throws Exception {
		init();
		setBackground(Color.WHITE);
		setDoubleBuffered(true); //Each image is buffered twice to avoid tearing / stutter
		JOptionPane.showMessageDialog(null,
				"Control the character by using the Arrow keys\n Press X to advance a tile and C to interact with an object", "Rules",
				JOptionPane.DEFAULT_OPTION);
		timer = new Timer(100, this); //calls the actionPerformed() method every 100ms
		timer.start(); //Start the timer
	}
	
	/**
	 * Initalize the class by importing images and setting local variables from other classes
	 */
	private void init() throws Exception {
		Setup s = new SetupImplementor();
		tiles = s.loadImages("./resources/images/ground", tiles);
		objects = s.loadImages("./resources/images/objects", objects);
		things = ob.setLevel();
		matrix = lb.setLevel();
		player = SpriteFactory.getCharacter("Player 1", new PointHandler(0, 0), s.loadImages("./resources/images/sprites/person", null));
	}

	/**
	 * Toggle the view from isometric to cartesian, or vice versa
	 */
	public void toggleView() {
		isIsometric = !isIsometric;
		this.repaint();
	}

	/**
	 * This is called each time the timer reaches zero
	 */
	public void actionPerformed(ActionEvent e) { 
		this.repaint();
	}

	/**
	 * Calls the LevelPainter class, and two private methods within this class.
	 * Also contains check to see if the character has entered water by calling another private method
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		LevelPainter painter = new LevelPainter(g2, matrix, things, isIsometric, tiles, objects);
		
		paintPlayer(g2, isIsometric);
		
		pickupCheck(g2);
		
		if(waterWalk == false) {
			waterCheck();
		}
	}
	
	/**
	 * Private method that checks if the players quest methods are true or false, and drawing on the canvas depending on result
	 * @param g2
	 */
	private void pickupCheck(Graphics2D g2) {
		//Checks if the player has the Water walking boots
		if(player.getBoots() == true) {
			g2.drawString("Picked Up Boots of Water Walking!", 10, 10);
			things[6][5] = 0;
			waterWalk = true;
		}
		
		//Checks if the player has the key
		if(player.getKey() == true) {
			g2.drawString("Picked Up Key", 10, 50);
			things[9][0] = Items.emptyFountain.getItem();
		}
		
		//Checks if the player tries to obtain the key without the cup
		if(player.getPosition().getX() == 0 && player.getPosition().getY() == 9 && player.getKey() == false) {
			g2.drawString("You'll need something to take the water out!", 900, 30);
		}
		
		//Checks if the player has read the sign
		if(player.getSign() == true) {
			g2.drawString("The Sign Reads: You must drink from the fountain to unlock your way", 900, 10);
		}
		
		//Checks if the player has obtaained a cup
		if(player.getCup() == true) {
			g2.drawString("You have a refreshing cup of lemonade! You now own a cup!", 10, 30);
		}
		
		//Checks if the player tries to use the key on the manhole without a key
		if(player.getPosition().getX() == 9 && player.getPosition().getY() == 2 && player.getManhole() == false) {
			g2.drawString("You'll need a key to escape!", 900, 50);
		}
		
		//Checks if the player tries to use the key on the manhoe with the key
		if(player.getManhole() == true) {
			gameOver = true;
			timer.stop();
			gameOverCheck();
		}
	}
	
	/**
	 * Private method used to check of the player has the boots of water walking. If they do not then a game over dialog appears and the application is closed.
	 * Due to time constraints I was unable to implement a restart option
	 */
	private void waterCheck() {
		//Hard coded that if a player steps in a certain position the game will end
		for(int i = 0; i < 8; i++) {
			if(player.getPosition().getX() == i && player.getPosition().getY() == 8) {
				timer.stop();
				JOptionPane.showMessageDialog(null,
						"You've Drown!", "Game Over",
						JOptionPane.DEFAULT_OPTION);
				System.exit(0);
			}
		}
	}

	/**
	 * Private method that calls the point handler class to determine where the player is positioned
	 * @param g2 Graphics2D variable to draw on the canvas
	 * @param isIso Checks what view the user is in and determines the point through that
	 */
	private void paintPlayer(Graphics2D g2, boolean isIso) {
		PointHandler point;
		Point ph = new PointHandler(0, 0);
		
		ph = ph.getPoint(player.getPosition().getX(), player.getPosition().getY(), isIsometric);
		point = (PointHandler) ph;
		g2.drawImage(player.getImage(), point.getX(), point.getY(), null);
	}
	
	/**
	 * Public method used to check if the user presses a key
	 */
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
	
	/**
	 * Private method used to check if the game has ended
	 */
	private void gameOverCheck() {
		if(gameOver == true) {
			JOptionPane.showMessageDialog(null,
					"You've Completed the game!", "Completion",
					JOptionPane.DEFAULT_OPTION);
			System.exit(0);
		}
	}
}