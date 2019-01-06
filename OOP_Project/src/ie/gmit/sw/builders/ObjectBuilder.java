package ie.gmit.sw.builders;

import ie.gmit.sw.enums.Items;
import ie.gmit.sw.interfaces.Level;

/**
 * ObjectBulder with implements the Level interface. This builds the objects on the canvas that the player can interact with.
 * @author Ryan Conway
 *
 */
public class ObjectBuilder implements Level {

		// initalize 2D object Array
		int[][] objects = new int[10][10];
		
		Items item;
		
		/**
		 * Getter for the Items Enum
		 * @return item value
		 */
		public Items getItems() {
			return item;
		}
		
		/**
		 * Setter for the Items Enum
		 * @param item
		 */
		public void setItem(Items item) {
			this.item = item;
		}
				
		/**
		 * Method that calls all the private methods and returns the updated 2D array of objects
		 */
		public int[][] setLevel() {
			// TODO Auto-generated method stub
			setTrees(Items.tree);
			setChest(Items.chest);
			setFountain(Items.fonutain);
			setSign(Items.sign);
			setStand(Items.stand);
			setFire(Items.fire);
			setManhole(Items.hole);
			return objects;
		}

		/**
		 * Private method that sets the tree value in certain points of the array
		 */
		private void setTrees(Items item) {
			setItem(item);
			// TODO Auto-generated method stub
			objects[1][0] = item.getItem();
			objects[2][0] = item.getItem();
			objects[2][1] = item.getItem();
			objects[0][5] = item.getItem();
			objects[0][6] = item.getItem();
			objects[1][5] = item.getItem();
			objects[1][6] = item.getItem();
			objects[1][7] = item.getItem();
			objects[2][5] = item.getItem();
			objects[2][6] = item.getItem();
			objects[2][7] = item.getItem();
			objects[3][5] = item.getItem();
			objects[3][6] = item.getItem();
			objects[3][7] = item.getItem();
		}
		
		/**
		 * Private method that sets the chest value in certain points of the array
		 */
		private void setChest(Items item) {
			objects[6][5] = item.getItem();
		}
		
		/**
		 * Private method that sets the fountain value in certain points of the array
		 */
		private void setFountain(Items item) {
			objects[9][0] = item.getItem();
		}
		
		/**
		 * Private method that sets the sign value in certain points of the array
		 */
		private void setSign(Items item) {
			objects[3][2] = item.getItem();
		}
		
		/**
		 * Private method that sets the stand value in certain points of the array
		 */
		private void setStand(Items item) {
			objects[0][7] = item.getItem();
		}
		
		/**
		 * Private method that sets the fire value in certain points of the array
		 */
		private void setFire(Items item) {
			objects[9][9] = item.getItem();
		}
		
		/**
		 * Private method that sets the manhole value in certain points of the array
		 */
		private void setManhole(Items item) {
			objects[2][9] = item.getItem();
		}
}
