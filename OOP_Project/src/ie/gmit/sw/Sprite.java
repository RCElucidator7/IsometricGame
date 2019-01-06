package ie.gmit.sw;

/*
 *   
 *   BufferedImage[][]
 *   --------------------------
 *   {U0, U1, U2, U3}, =>Up
 *   {D0, D1, D2, D3}, =>Down
 *   {L0, L1, L2, L3}, =>Left
 *   {R0, R1, R2, R3}, =>Right
 * 
 */

import java.awt.image.*;
/**
 * Sprite class that implements both the Character interface and Quest interface. This class controls the character
 * Sprite such as the movement, direction it faces and whether the character has obtained any items or not.
 * @author Ryan Conway
 *
 */
public class Sprite implements Character, Quest {
	private String name; //The name of the sprite
	private BufferedImage[][] images = new BufferedImage[4][3]; //The images used in the animation 
	private Direction direction = Direction.DOWN; //The current orientation of the sprite
	private int index = 0; //The current image index.
	private PointHandler position; //The current x, y position
	private boolean bootsPickup = false;
	private boolean keyPickup = false;
	private boolean signRead = false;
	private boolean cupPickup = false;
	private boolean manholePickup = false;
	
	/**
	 * Default sprite constructor
	 * @param name sprite name
	 * @param p sprite point on the canvas
	 */
	public Sprite(String name, PointHandler p) {
		super();
		this.name = name;
		this.position = p;
	}
	
	/**
	 * Constructor that stores the images that will be used in the animation
	 * @param name sprite name
	 * @param p sprite point on the canvas
	 * @param img Array of images from the resource folder
	 */
	public Sprite(String name, PointHandler p, BufferedImage[] img) {
		this(name, p);
		int row = 0, col = 0;
		for (int i = 0; i < img.length; i++) {
			images[row][col] = img[i];
			if (col == images[row].length - 1) {
				row++;
				col = 0;
			}else {
				col++;
			}
		}
	}

	/**
	 * Get sprite name
	 * @return sprite name
	 */
	public String getName() {
		return name;
	}

	/**
	 * get sprite position
	 * @return sprite position
	 */
	public PointHandler getPosition() {
		return position;
	}

	/**
	 * get sprite image
	 * @return sprite image
	 */
	public BufferedImage getImage() {
		return images[direction.getOrientation()][index];
	}
	
	/**
	 * Method implemented from the Character interface. Uses the Orientation of the character to determine which image to use on the sprite.
	 */
	@Override
	public BufferedImage step(Direction d) {
		setDirection(d);
		if (index < images[direction.getOrientation()].length - 1) {
			index++;
		}else {
			index = 0;
		}
		
		return images[d.getOrientation()][index];
	}
	
	/**
	 * Sets the Orientation of the sprite in the canvas using the Direction Enum
	 * @param d Enum value of the direction
	 */
	public void setDirection(Direction d) {
		direction = d;
	}
	
	/*
	 * Gets the value of the Orientation
	 */
    public Direction getDirection() {
        return this.direction;
    }
    
    /**
     * Method implemented from the character interface. Checks the players position and 
     * determines if they pick up an item or not, using methods from the Quest interface.
     */
    @Override
    public void pickup() {
    	if(position.getX() == 5 && position.getY() == 6) {
    		setBoots(true);
    	}
    	if(position.getX() == 0 && position.getY() == 9 && getBoots() == true && getCup() == true) {
    		setKey(true);
    	}
    	if(position.getX() == 2 && position.getY() == 3) {
    		setSign(true);
    	}
    	if(position.getX() == 7 && position.getY() == 0) {
    		setCup(true);
    	}
    	if(position.getX() == 9 && position.getY() == 2 && getKey() == true) {
    		setManhole(true);
    	}
    }
	
    /**
     * Move method implemented from the Character interface. Determines if the character can move to the next tile. If statements added 
     * to the switch function to determine if the character is on the border or not...Messy stuff but it works for now
     */
    @Override
	public void move() {
		step(direction);
		
		switch(direction.getOrientation()) {
		case 1:
			if(position.getY() == 9) {
				break;
			}
			position.setY(position.getY() + 1); //UP
			break;
		case 2:
			if(position.getX() == 0) {
				break;
			}
			position.setX(position.getX() - 1); //DOWN
			break;
		case 3:
			if(position.getX() == 9) {
				break;
			}
			position.setX(position.getX() + 1); //LEFT
			break;
		default:
			if(position.getY() == 0) {
				break;
			}
			position.setY(position.getY() - 1); //RIGHT
			break;
		}
	}
    
    /**
     * gets the value of the bootsPickup variable
     */
	@Override
	public boolean getBoots() {
		return bootsPickup;
	}

	/**
	 * sets the value of the bootsPickup variable
	 */
	@Override
	public void setBoots(boolean boots) {
		this.bootsPickup = boots;
	}

	 /**
     * gets the value of the cupPickup variable
     */
	@Override
	public boolean getCup() {
		return cupPickup;
	}

	/**
	 * sets the value of the cupPickup variable
	 */
	@Override
	public void setCup(boolean cup) {
		this.cupPickup = cup;
	}

	 /**
     * gets the value of the keyPickup variable
     */
	@Override
	public boolean getKey() {
		return keyPickup;
	}

	/**
	 * sets the value of the keyPickup variable
	 */
	@Override
	public void setKey(boolean key) {
		this.keyPickup = key;
	}

	 /**
     * gets the value of the signRead variable
     */
	@Override
	public boolean getSign() {
		return signRead;
	}

	/**
	 * sets the value of the signRead variable
	 */
	@Override
	public void setSign(boolean sign) {
		this.signRead = sign;
	}

	 /**
     * gets the value of the manholePickup variable
     */
	@Override
	public boolean getManhole() {
		return manholePickup;
	}

	/**
	 * sets the value of the manholePickup variable
	 */
	@Override
	public void setManhole(boolean manhole) {
		this.manholePickup = manhole;
	}
}