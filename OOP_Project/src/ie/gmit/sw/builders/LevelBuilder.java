package ie.gmit.sw.builders;

import ie.gmit.sw.enums.Material;
import ie.gmit.sw.interfaces.Level;

/**
 * LevelBuilder class that implements the level interface.
 * Builds an array containing values for each of the tiles on the canvas.
 * @author Ryan Conway
 *
 */
public class LevelBuilder implements Level {

		//Initalize an array to manipulate and return
		int[][] grass = new int[10][10];
				
		Material material;

		/**
		 * Method that calls all other private methods in the class to build a 2D array of values
		 */
		public int[][] setLevel() {
			// TODO Auto-generated method stub
			setDirt(Material.dirt);
			setStone(Material.stone);
			setSea(Material.sea);
			setSand(Material.sand);
			setMossStone(Material.mossStone);
			return grass;
		}

		/**
		 * Getter for the material Enum
		 * @return material value
		 */
		public Material getMaterial() {
			return material;
		}

		/**
		 * Setter for the material Enum
		 * @param material
		 */
		public void setMaterial(Material material) {
			this.material = material;
		}

		/**
		 * Private method that sets the values for the dirt image into the 2D array
		 * @param mat enum type passed through
		 */
		private void setDirt(Material mat) {
			// TODO Auto-generated method stub
			grass[1][1] = mat.getMaterial();
			grass[1][2] = mat.getMaterial();
			grass[1][3] = mat.getMaterial();
			grass[2][3] = mat.getMaterial();
			grass[3][3] = mat.getMaterial();
		}
		
		/**
		 * Private method that sets the values for the stone image into the 2D array
		 * @param mat enum type passed through
		 */
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
		
		/**
		 * Private method that sets the values for the sea image into the 2D array
		 * @param mat enum type passed through
		 */
		private void setSea(Material mat) {
			// TODO Auto-generated method stub
			setMaterial(mat);
			for(int i = 0; i < 8; i++) {
				grass[8][i] = mat.getMaterial();
				grass[9][i] = mat.getMaterial();
			}
		}
		
		/**
		 * Private method that sets the values for the sand image into the 2D array
		 * @param mat enum type passed through
		 */
		private void setSand(Material mat) {
			// TODO Auto-generated method stub
			setMaterial(mat);
			for(int i = 0; i < 8; i++) {
				grass[7][i] = mat.getMaterial();
			}
		}
		
		/**
		 * Private method that sets the values for the mossy stone image into the 2D array
		 * @param mat enum type passed through
		 */
		private void setMossStone(Material mat) {
			// TODO Auto-generated method stub
			setMaterial(mat);
			for(int i = 0; i < 6; i++) {
				grass[i][9] = mat.getMaterial();
			}
		}

}
