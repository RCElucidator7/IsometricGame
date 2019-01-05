package ie.gmit.sw.models;

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
	
	public final int DEFAULT_VIEW_SIZE = 1280;
	public final int TILE_WIDTH = 128;
	public final int TILE_HEIGHT = 64;
	
	@Override
	public int getIsoX(int x, int y) {
		int rshift = (DEFAULT_VIEW_SIZE/2) - (TILE_WIDTH/2) + (x - y); //Pan camera to the right
		return (x - y) * (TILE_WIDTH/2) + rshift;
	}

	@Override
	public int getIsoY(int x, int y) {
		return (x + y) * (TILE_HEIGHT/2);
	}
	
	@Override
	public PointHandler getPoint(int x, int y, boolean isIsometric) {
		if(isIsometric == true) {
			return new PointHandler(getIsoX(x, y), getIsoY(x, y)); //Could be more efficient...
		}
		else {
			return new PointHandler(x*TILE_WIDTH, y*TILE_HEIGHT);
		}
	}
	
	//return new Point(x*TILE_WIDTH, y*TILE_HEIGHT); //Could be more efficient...
}