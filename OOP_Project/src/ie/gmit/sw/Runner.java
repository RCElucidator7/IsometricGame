package ie.gmit.sw;


import javax.swing.JOptionPane;

import ie.gmit.sw.views.GameWindow;

/**
 * Runner class that gets an instance of the game window class and runs the game.
 * @author Ryan Conway
 *
 */
public class Runner {
	
	public static void main(String[] args) throws Exception {		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					/* 
					 * ----------------------------------------
					 *             Control Keys
					 * ----------------------------------------
					 * Use the arrow keys to move the player.
					 * Move Player: 'X'
					 * Toggle View: 'Z'	
					 * Toggle Action: 'C'		
					 * ----------------------------------------
					 */
					GameWindow.getIntance();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Program failed to start", "Failure", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}