package ie.gmit.sw.models;

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
public class Sprite { //Sprite belongs in some sort of hierarchy....
	private String name; //The name of the sprite
	private BufferedImage[][] images = new BufferedImage[4][3]; //The images used in the animation 
	private Direction direction = Direction.DOWN; //The current orientation of the sprite
	private int index = 0; //The current image index.
	private Point position; //The current x, y position
	private boolean rowPickup = false;
	private boolean keyPickup = false;
	
	public Sprite(String name, Point p, boolean row, boolean key) {
		super();
		this.name = name;
		this.position = p;
		this.rowPickup = row;
		this.keyPickup = key;
	}
	
	public Sprite(String name, Point p, boolean pu, boolean key, BufferedImage[] img) {
		this(name, p, pu, key);
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

	public String getName() {
		return name;
	}

	public Point getPosition() {
		return position;
	}
	
	public boolean getPickup() {
		return rowPickup;
	}
	
	public boolean getKey() {
		return keyPickup;
	}

	public BufferedImage getImage() {
		return images[direction.getOrientation()][index];
	}
	
	public BufferedImage step(Direction d) {
		setDirection(d);
		if (index < images[direction.getOrientation()].length - 1) {
			index++;
		}else {
			index = 0;
		}
		
		return images[d.getOrientation()][index];
	}
	
	public void setDirection(Direction d) {
		direction = d;
	}
	
    public Direction getDirection() {
        return this.direction;
    }
    
    public void pickup() {
    	if(position.getX() == 5 && position.getY() == 6) {
    		rowPickup = true;
    	}
    	if(position.getX() == 0 && position.getY() == 9) {
    		keyPickup = true;
    	}
    }
	
	public void move() { //This method is suspiciously like one I've seen already....
		step(direction);
		
		switch(direction.getOrientation()) {
		case 1:
			if(position.getY() == 9) {
				break;
			}
			position.setY(position.getY() + 1); //UP
			System.out.println(getPickup());
			break;
		case 2:
			if(position.getX() == 0) {
				break;
			}
			position.setX(position.getX() - 1); //DOWN
			System.out.println(getPickup());
			break;
		case 3:
			if(position.getX() == 9) {
				break;
			}
			position.setX(position.getX() + 1); //LEFT
			System.out.println(getPickup());
			break;
		default:
			if(position.getY() == 0) {
				break;
			}
			position.setY(position.getY() - 1); //RIGHT
			System.out.println(getPickup());
			break;
		}
	}
}