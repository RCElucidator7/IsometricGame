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
public class Sprite implements Character, Quest { //Sprite belongs in some sort of hierarchy....
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
	private boolean checkWater = false;
	
	public Sprite(String name, PointHandler p) {
		super();
		this.name = name;
		this.position = p;
	}
	
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

	public String getName() {
		return name;
	}

	public PointHandler getPosition() {
		return position;
	}
	
	@Override
	public boolean getBoots() {
		return bootsPickup;
	}

	@Override
	public void setBoots(boolean boots) {
		this.bootsPickup = boots;
	}

	public BufferedImage getImage() {
		return images[direction.getOrientation()][index];
	}
	
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
	
	public void setDirection(Direction d) {
		direction = d;
	}
	
    public Direction getDirection() {
        return this.direction;
    }
    
    @Override
    public void pickup() {
    	if(position.getX() == 5 && position.getY() == 6) {
    		setBoots(true);
    		System.out.println(getBoots());
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
    	if(position.getX() == 2 && position.getY() == 9 && getKey() == true) {
    		setManhole(true);
    	}
    }
	
    @Override
	public void move() { //This method is suspiciously like one I've seen already....
		step(direction);
		
		switch(direction.getOrientation()) {
		case 1:
			if(position.getY() == 9) {
				break;
			}
			position.setY(position.getY() + 1); //UP
			System.out.println(getBoots());
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

	@Override
	public boolean getCup() {
		return cupPickup;
	}

	@Override
	public void setCup(boolean cup) {
		this.cupPickup = cup;
	}

	@Override
	public boolean getKey() {
		return keyPickup;
	}

	@Override
	public void setKey(boolean key) {
		this.keyPickup = key;
	}

	@Override
	public boolean getSign() {
		return signRead;
	}

	@Override
	public void setSign(boolean sign) {
		this.signRead = sign;
	}

	@Override
	public boolean getManhole() {
		return manholePickup;
	}

	@Override
	public void setManhole(boolean manhole) {
		this.manholePickup = manhole;
	}
}