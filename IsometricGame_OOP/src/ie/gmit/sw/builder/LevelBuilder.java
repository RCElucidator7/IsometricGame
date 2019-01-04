package ie.gmit.sw.builder;

import ie.gmit.sw.models.*;

public class LevelBuilder implements Level {

		int[][] grass = new int[10][10];
		
		int[][] things = new int[10][10];
		
		Material material;

		public int[][] setGround() {
			// TODO Auto-generated method stub
			setThing(Material.dirt);
			setStone(Material.stone);
			setSea(Material.sea);
			setSand(Material.sand);
			return grass;
		}

		public Material getMaterial() {
			return material;
		}

		public void setMaterial(Material material) {
			this.material = material;
		}

		public void setThing(Material mat) {
			// TODO Auto-generated method stub
			setMaterial(mat);
			for(int i = 0; i < 10; i++) {
				grass[i][i] = mat.getMaterial();
			}
		}
		
		public void setStone(Material mat) {
			// TODO Auto-generated method stub
			setMaterial(mat);
			for(int i = 0; i < 8; i++) {
				if(i > 4) {
					grass[i][5] = mat.getMaterial();
				}
				else {
					grass[i][4] = mat.getMaterial();
				}
			}
		}
		
		public void setSea(Material mat) {
			// TODO Auto-generated method stub
			setMaterial(mat);
			for(int i = 0; i < 8; i++) {
				grass[8][i] = mat.getMaterial();
				grass[9][i] = mat.getMaterial();
			}
		}
		
		public void setSand(Material mat) {
			// TODO Auto-generated method stub
			setMaterial(mat);
			for(int i = 0; i < 8; i++) {
				grass[7][i] = mat.getMaterial();
			}
		}

}
