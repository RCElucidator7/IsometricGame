package ie.gmit.sw.builder;

public class LevelBuilder implements Level {

		int[][] grass = { 
				{ 0, 0, 0, 2, 0, 0 , 0, 0, 0, 2},
				{ 0, 0, 0, 2, 0, 0 , 0, 0, 0, 2},
				{ 0, 0, 0, 2, 0, 0 , 0, 0, 0, 2},
				{ 0, 0, 0, 2, 0, 0 , 0, 0, 0, 2},
				{ 2, 2, 2, 2, 1, 0 , 0, 0, 0, 2},
				{ 3, 3, 3, 3, 1, 1 , 1, 0, 0, 1},
				{ 5, 5, 5, 5, 3, 3 , 1, 0, 0, 1},
				{ 4, 4, 4, 4, 5, 5, 5, 5, 3, 3},
				{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
		};
		
		int[][] things = { 
				{ 0, 0, 0, 0, 0, 0 , 5, 5, 5, 10},
				{ 5, 0, 0, 0, 0, 0 , 5, 5, 5, 0},
				{ 5, 5, 0, 0, 0, 0 , 5, 5, 5, 9},
				{ 5, 5, 2, 0, 0, 0 , 5, 5, 5, 0},
				{ 0, 0, 0, 0, 0, 0 , 0, 5, 5, 0},
				{ 0, 0, 0, 0, 0, 0 , 0, 0, 5, 0},
				{ 0, 0, 0, 0, 0, 3 , 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0}
		};

	@Override
	public void setMaterial(int m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int setMaterial() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setThing(int t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int setThing() {
		// TODO Auto-generated method stub
		return 0;
	}

}
