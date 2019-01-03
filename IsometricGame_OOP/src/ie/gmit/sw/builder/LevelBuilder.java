package ie.gmit.sw.builder;

public class LevelBuilder implements Level {

		int[][] grass = new int[9][9];
		
		int[][] things = new int[9][9];

		@Override
		public int[][] setMaterial() {
			// TODO Auto-generated method stub
			grass[0][2] = 2;
			grass[1][2] = 2;
			grass[2][2] = 2;
			grass[3][2] = 2;
			grass[4][2] = 2;
			grass[5][2] = 2;
			grass[6][2] = 2;
			
			return grass;
		}

		@Override
		public void setThing() {
			// TODO Auto-generated method stub
			
		}



}
