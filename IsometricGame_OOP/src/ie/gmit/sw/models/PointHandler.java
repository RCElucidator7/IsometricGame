package ie.gmit.sw.models;

public interface PointHandler {
	int getIsoX(int x, int y); 
	int getIsoY(int x, int y);
	Point getPoint(int x, int y, boolean isIsometric);
}
