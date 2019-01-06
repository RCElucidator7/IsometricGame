package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;

/**
 * Implements the Setup interface. Used to load in the images from the resources folder.
 * @author Ryan Conway
 *
 */
public class SetupImplementor implements Setup {

	public BufferedImage[] loadImages(String directory, BufferedImage[] tiles) throws Exception {

		File dir = new File(directory);
		File[] files = dir.listFiles();

		Arrays.sort(files, (s, t) -> s.getName().compareTo(t.getName()));
		
		BufferedImage[] img = new BufferedImage[files.length];

		for (int i = 0; i < files.length; i++) {
			img[i] = ImageIO.read(files[i]);
		}
		
		return img;
	}

}
