package ie.gmit.sw;

/**
 * Enum that stores the values for each ground material value to correlate with the resource values.
 * @author Ryan Conway
 *
 */
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
	
	/**
	 * Private constructor that sets the material
	 * @param mat Which material to set.
	 */
	private Material(int mat) {
		this.mat = mat;
	}
	
	/**
	 * get method that returns the value of the material
	 * @return
	 */
	public int getMaterial() {
		return this.mat;
	}
	
}
