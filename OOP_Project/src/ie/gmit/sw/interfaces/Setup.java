package ie.gmit.sw.interfaces;

import java.awt.image.BufferedImage;

/**
 * Setup interface implemented by the setup implementor. Used to load in the images from the resources folder
 * @author Ryan Conway
 *
 */
public interface Setup {		
		public BufferedImage[] loadImages(String directory, BufferedImage[] tiles) throws Exception;	
}
