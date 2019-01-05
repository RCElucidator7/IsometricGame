package ie.gmit.sw.models;

import java.awt.image.BufferedImage;

public interface Character {
	void move();
	void pickup();
	BufferedImage step(Direction d);
}
