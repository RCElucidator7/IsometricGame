package ie.gmit.sw.sprites;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import ie.gmit.sw.handlerss.PointHandler;

/**
 * SpriteFactory assigns the sprite to a HashMap and returns it as a type Sprite. Factory Pattern/Flyweight
 * @author Ryan Conway
 *
 */
public class SpriteFactory {

	//Initalize the HashMap
	private static final HashMap<String, Sprite> spriteMap = new HashMap<>();
	
	/**
	 * getCharacter method that assigns the values passed in to a sprite map and returns the map as a type sprite
	 * @param name the name of the sprite
	 * @param point the point of the sprite
	 * @param img an image Array of the sprites to be used
	 * @return a complete Sprite Type
	 */
	public static Sprite getCharacter(String name, PointHandler point, BufferedImage[] img) {
		//Set the sprite using the hashmap
		Sprite character = (Sprite) spriteMap.get(name);
		
		//If the sprite is null then create a new sprite
		if(character == null) {
			character = new Sprite(name, point, img);
			spriteMap.put(name, character);
			
		}
		return character;		
	}
}
