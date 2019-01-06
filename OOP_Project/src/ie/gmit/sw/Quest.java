package ie.gmit.sw;

/**
 * Quest interface implemented by the Sprite class. Used to determine if the character has picked up an item or not
 * @author Ryan Conway
 *
 */
public interface Quest {
	public boolean getBoots();
	public void setBoots(boolean boots);
	public boolean getCup();
	public void setCup(boolean cup);
	public boolean getKey();
	public void setKey(boolean key);
	public boolean getSign();
	public void setSign(boolean sign);
	public boolean getManhole();
	public void setManhole(boolean manhole);
}
