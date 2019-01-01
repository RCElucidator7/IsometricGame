package ie.gmit.sw;

import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import ie.gmit.sw.views.GameWindow;

public class Runner {
	static BufferedImage[] tiles = null;
	static BufferedImage[] objects = null;
	
	public static void main(String[] args) throws Exception {
		//Can read in necessary information here and process it before going any further...
		
		//Never run a GUI in the same thread as the main method... This is asynchronous:
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					//callSetup();
					/* 
					 * ----------------------------------------
					 *             Control Keys
					 * ----------------------------------------
					 * Use the arrow keys to move the player.
					 * Move Player: 'X'
					 * Toggle View: 'Z'		
					 * ----------------------------------------
					 */
					GameWindow.getIntance(); //Could be done nicer? - done?
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Program failed to start", "Failure", JOptionPane.ERROR_MESSAGE);
					//e.printStackTrace(); //Real lazy stuff here...
				}
			}
		});
	}
	
	/*public static void callSetup() throws Exception {
		Setup s = new SetupImplementor();
		tiles = s.loadImages("./resources/images/ground", tiles);
		objects = s.loadImages("./resources/images/objects", objects);
		Sprite player = new Sprite("Player 1", new Point(0, 0), s.loadImages("./resources/images/sprites/default", null));
	}*/
}