package ie.gmit.sw.painter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ie.gmit.sw.Constants;
import ie.gmit.sw.handlerss.PointHandler;
import ie.gmit.sw.interfaces.Point;

/**
 * LevelPainter class paints the images passed through from the GamwView class onto the canvas.
 * @author Ryan Conway
 *
 */
public class LevelPainter {
	
	//Initialize the image index, x pos and y pos
	int imageIndex = -1, x1 = 0, y1 = 0;
	private Color[] cartesian = {Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW, Color.PINK, Color.BLACK}; //This is a 2D representation
	
	/**
	 * Constructor to Paint the images passed through onto the canvas
	 * @param g2 Graphics2D variable to draw on the canvas
	 * @param matrix 2D Array that stores the values of the size of the total tiles on the canvas
	 * @param things 2D Array that stores the values of the objects
	 * @param isIsometric Boolean to check if the camera is isometric or not
	 * @param tiles Array of images imported containing the level tiles
	 * @param objects Array of images imported containing the objects
	 */
	public LevelPainter(Graphics2D g2, int[][] matrix, int[][] things, boolean isIsometric, BufferedImage[] tiles, BufferedImage[] objects) {
		
		imageIndex = -1;
		x1 = 0;
		y1 = 0;
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				imageIndex = matrix[row][col];
				
				if (imageIndex >= 0 && imageIndex < tiles.length) {
					//Paint the ground tiles
					if (isIsometric) {
						paintIso(col, row, things, tiles, objects, g2);
					} else {
						paintCart(col, row, things, g2, objects);
					}
					//Paint the object or things on the ground
					imageIndex = things[row][col];
					g2.drawImage(objects[imageIndex], x1, y1, null);
				}
			}
		}
	}
	
	/**
	 * Private method that paints the isometric view if the view is in isometric
	 * @param col Column number passed through
	 * @param row Row number passed through
	 * @param things 2D Array containing the values of the objects
	 * @param tiles Array of images imported containing the level tiles
	 * @param objects Array of images imported containing the objects
	 * @param g2 Graphics2D variable to draw on the canvas
	 */
	private void paintIso(int col, int row, int[][] things, BufferedImage[] tiles, BufferedImage[] objects, Graphics2D g2) {
		Point ph1 = new PointHandler(0, 0);
		
		x1 = ph1.getIsoX(col, row);
		y1 = ph1.getIsoY(col, row);
		
		g2.drawImage(tiles[Constants.DEFAULT_IMAGE_INDEX], x1, y1, null);
		if (imageIndex > Constants.DEFAULT_IMAGE_INDEX) {
			g2.drawImage(tiles[imageIndex], x1, y1, null);
		}
	}
	
	/**
	 * Private method that paints the cartesian view if the view is not in isometric
	 * @param col Column number passed through
	 * @param row Row number passed through
	 * @param things 2D Array containing the values of the objects
	 * @param g2 Graphics2D variable to draw on the canvas
	 * @param objectsArray of images imported containing the objects
	 */
	private void paintCart(int col, int row, int[][] things, Graphics2D g2, BufferedImage[] objects) {
		x1 = col * Constants.TILE_WIDTH;
		y1 = row * Constants.TILE_HEIGHT;
		if (imageIndex < cartesian.length) {
			g2.setColor(cartesian[imageIndex]);
		}else {
			g2.setColor(Color.WHITE);
		}
		
		g2.fillRect(x1, y1, Constants.TILE_WIDTH, Constants.TILE_WIDTH);
		
	}
}
