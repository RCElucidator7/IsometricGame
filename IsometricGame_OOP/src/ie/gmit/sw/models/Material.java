package ie.gmit.sw.models;

public enum Material {
	grass (0),
	stone (1),
	mossStone (2),
	sand (3),
	sea (4),
	sandSea (5),
	dirt (6),
	gravel (7);
	
	
	final private int mat;
	
	private Material(int mat) {
		this.mat = mat;
	}
	
	public int getMaterial() {
		return this.mat;
	}
	
}
