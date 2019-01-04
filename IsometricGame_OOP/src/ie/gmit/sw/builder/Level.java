package ie.gmit.sw.builder;

import ie.gmit.sw.models.Material;

public interface Level {
	public int[][] setGround();
	public void setThing(Material mat);
}
