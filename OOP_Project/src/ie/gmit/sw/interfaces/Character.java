package ie.gmit.sw.interfaces;

import java.awt.image.BufferedImage;

import ie.gmit.sw.enums.Direction;

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
