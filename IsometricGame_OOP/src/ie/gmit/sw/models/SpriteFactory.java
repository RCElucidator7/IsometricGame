package ie.gmit.sw.models;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class SpriteFactory {

	@SuppressWarnings({ })
	private static final HashMap<String, Sprite> spriteMap = new HashMap<>();
	
	
	public static Sprite getCharacter(String name, PointHandler point, boolean check1, boolean check2, BufferedImage[] img) {
		Sprite character = (Sprite) spriteMap.get(name);
		
		if(character == null) {
			character = new Sprite(name, point, check2, check2, img);
			spriteMap.put(name, character);
			
		}
		System.out.println(character.getName());
		return character;
		
	}
}
