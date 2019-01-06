package ie.gmit.sw.interfaces;

import ie.gmit.sw.handlerss.PointHandler;

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
