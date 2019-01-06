package ie.gmit.sw.enums;

/**
 * Enum that stores the values for each item value to correlate with the resource values.
 * @author Ryan Conway
 *
 */
public enum Items {
	fonutain (1),
	sign (2),
	chest (3),
	tree (5),
	emptyFountain (6),
	hole (8),
	fire (10),
	stand (11);
	
	
	final private int item;
	
	/**
	 *Private constructor to set the item
	 */
	private Items(int item) {
		this.item = item;
	}
	
	/**
	 * get method that returns the item
	 * @return
	 */
	public int getItem() {
		return this.item;
	}
}
