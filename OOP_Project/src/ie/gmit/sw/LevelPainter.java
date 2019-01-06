package ie.gmit.sw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class LevelPainter {

	private static final int DEFAULT_IMAGE_INDEX = 0;
	public static final int DEFAULT_VIEW_SIZE = 1280;
	private static final int TILE_WIDTH = 128;
	private static final int TILE_HEIGHT = 64;
	
	int imageIndex = -1, x1 = 0, y1 = 0;
	private Color[] cartesian = {Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW, Color.PINK, Color.BLACK}; //This is a 2D representation
	
	
	public LevelPainter(Graphics2D g2, int[][] matrix, int[][] things, boolean isIsometric, BufferedImage[] tiles, BufferedImage[] objects) {
		//tiles = s.loadImages("./resources/images/ground", tiles);
		//objects = s.loadImages("./resources/images/objects", objects);
		
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
	
	private void paintIso(int col, int row, int[][] things, BufferedImage[] tiles, BufferedImage[] objects, Graphics2D g2) {
		Point ph1 = new PointHandler(0, 0);
		
		x1 = ph1.getIsoX(col, row);
		y1 = ph1.getIsoY(col, row);
		
		g2.drawImage(tiles[DEFAULT_IMAGE_INDEX], x1, y1, null);
		if (imageIndex > DEFAULT_IMAGE_INDEX) {
			g2.drawImage(tiles[imageIndex], x1, y1, null);
		}
	}
	
	private void paintCart(int col, int row, int[][] things, Graphics2D g2, BufferedImage[] objects) {
		x1 = col * TILE_WIDTH;
		y1 = row * TILE_HEIGHT;
		if (imageIndex < cartesian.length) {
			g2.setColor(cartesian[imageIndex]);
		}else {
			g2.setColor(Color.WHITE);
		}
		
		g2.fillRect(x1, y1, TILE_WIDTH, TILE_WIDTH);
		
	}
}
