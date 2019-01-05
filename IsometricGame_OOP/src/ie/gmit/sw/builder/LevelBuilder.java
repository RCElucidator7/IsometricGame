package ie.gmit.sw.builder;

import ie.gmit.sw.models.*;

public class LevelBuilder implements Level {

		int[][] grass = new int[10][10];
		
		int[][] things = new int[10][10];
		
		Material material;

		public int[][] setGround() {
			// TODO Auto-generated method stub
			setDirt(Material.dirt);
			setStone(Material.stone);
			setSea(Material.sea);
			setSand(Material.sand);
			setMossStone(Material.mossStone);
			return grass;
		}

		public Material getMaterial() {
			return material;
		}

		public void setMaterial(Material material) {
			this.material = material;
		}

		private void setDirt(Material mat) {
			// TODO Auto-generated method stub
			grass[1][1] = mat.getMaterial();
			grass[1][2] = mat.getMaterial();
			grass[1][3] = mat.getMaterial();
			grass[2][3] = mat.getMaterial();
			grass[3][3] = mat.getMaterial();
		}
		
		private void setStone(Material mat) {
			// TODO Auto-generated method stub
			setMaterial(mat);
			for(int i = 0; i < 8; i++) {
				if(i > 4) {
					grass[i-1][5] = mat.getMaterial();
				}
				else {
					grass[i][4] = mat.getMaterial();
					grass[0][i] = mat.getMaterial();
				}
			}
		}
		
		private void setSea(Material mat) {
			// TODO Auto-generated method stub
			setMaterial(mat);
			for(int i = 0; i < 8; i++) {
				grass[8][i] = mat.getMaterial();
				grass[9][i] = mat.getMaterial();
			}
		}
		
		private void setSand(Material mat) {
			// TODO Auto-generated method stub
			setMaterial(mat);
			for(int i = 0; i < 8; i++) {
				grass[7][i] = mat.getMaterial();
			}
		}
		
		private void setMossStone(Material mat) {
			// TODO Auto-generated method stub
			setMaterial(mat);
			for(int i = 0; i < 6; i++) {
				grass[i][9] = mat.getMaterial();
			}
		}

}
