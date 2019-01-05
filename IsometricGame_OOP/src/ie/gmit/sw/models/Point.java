package ie.gmit.sw.models;

public interface Point {
	int getIsoX(int x, int y); 
	int getIsoY(int x, int y);
	PointHandler getPoint(int x, int y, boolean isIsometric);
}
