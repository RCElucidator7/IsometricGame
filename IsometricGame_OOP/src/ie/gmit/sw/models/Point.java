package ie.gmit.sw.models;

public class Point implements PointHandler{
	private int x;
	private int y;
	
	public Point(int x, int y) {
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
	public Point getIso(int x, int y) {
		return new Point(getIsoX(x, y), getIsoY(x, y)); //Could be more efficient...
	}
	
	@Override
	public Point getCart(int x, int y) {		
		return new Point(x*TILE_WIDTH, y*TILE_HEIGHT); //Could be more efficient...
	}
}