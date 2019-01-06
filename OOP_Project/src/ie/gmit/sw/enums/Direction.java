package ie.gmit.sw.enums;

/**
 * Enum that has values assigned for each direction to determine the orientation of the character
 * @author Ryan Conway
 *
 */
public enum Direction {
	UP (0), 
	DOWN (1), 
	LEFT (2), 
	RIGHT (3);

	private final int orientation;

    private Direction(int orientation) {
        this.orientation = orientation;
    }
    
    public int getOrientation() {
        return this.orientation;
    }
}