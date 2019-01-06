package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class SpriteFactory {

	@SuppressWarnings({ })
	private static final HashMap<String, Sprite> spriteMap = new HashMap<>();
	
	
	public static Sprite getCharacter(String name, PointHandler point, BufferedImage[] img) {
		Sprite character = (Sprite) spriteMap.get(name);
		
		if(character == null) {
			character = new Sprite(name, point, img);
			spriteMap.put(name, character);
			
		}
		System.out.println(character.getName());
		return character;
		
	}
}
