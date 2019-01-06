package ie.gmit.sw;

/**
 * PointHandler class implements the Point interface. Gets the point of the Sprite depending on its view, Isometric or Cartisan
 * @author Ryan Conway
 *
 */
public class PointHandler implements Point{
	private int x;
	private int y;
	
	public PointHandler(int x, int y) {
		super();
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
	
	@Override
	public int getIsoX(int x, int y) {
		int rshift = (Constants.DEFAULT_VIEW_SIZE/2) - (Constants.TILE_WIDTH/2) + (x - y); //Pan camera to the right
		return (x - y) * (Constants.TILE_WIDTH/2) + rshift;
	}

	@Override
	public int getIsoY(int x, int y) {
		return (x + y) * (Constants.TILE_HEIGHT/2);
	}
	
	@Override
	public PointHandler getPoint(int x, int y, boolean isIsometric) {
		if(isIsometric == true) {
			return new PointHandler(getIsoX(x, y), getIsoY(x, y)); //Could be more efficient...
		}
		else {
			return new PointHandler(x*Constants.TILE_WIDTH, y*Constants.TILE_HEIGHT);
		}
	}	
}