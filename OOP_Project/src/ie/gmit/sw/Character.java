package ie.gmit.sw;

import java.awt.image.BufferedImage;

/**
 * Interface for the character sprite
 * @author Ryan Conway
 *
 */
public interface Character {
	BufferedImage step(Direction d);
	void move();
	void pickup();
}
