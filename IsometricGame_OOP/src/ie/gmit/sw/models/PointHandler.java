package ie.gmit.sw.models;

public interface PointHandler {
	int getIsoX(int x, int y); 
	int getIsoY(int x, int y);
	Point getIso(int x, int y);
	Point getCart(int x, int y);
}
