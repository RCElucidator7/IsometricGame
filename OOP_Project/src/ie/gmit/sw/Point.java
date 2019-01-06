package ie.gmit.sw;

/**
 * Point interface containing methods for obtaining the isometric coordinates individually and together 
 * @author Ryan Conway
 *
 */
public interface Point {
	int getIsoX(int x, int y); 
	int getIsoY(int x, int y);
	PointHandler getPoint(int x, int y, boolean isIsometric);
}
