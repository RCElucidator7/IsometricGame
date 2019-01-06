package ie.gmit.sw;

import java.awt.*;
import javax.swing.*;

/**
 * GameWindow sets up the JFrame window and sets the size of the canvas
 * @author Ryan Conway
 *
 */
public class GameWindow {
	
	public static GameWindow gameInstance = null;
	
	//Constructor that sets up the window and canvas 
	public GameWindow(){
		try {
			GameView view = new GameView();
			Dimension d = new Dimension(Constants.DEFAULT_VIEW_SIZE, Constants.DEFAULT_VIEW_SIZE/2);
			view.setPreferredSize(d);
			view.setMinimumSize(d);
			view.setMaximumSize(d);
	
			JFrame f = new JFrame("GMIT - B.Sc. in Computing (Software Development)");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.getContentPane().setLayout(new FlowLayout());
			f.add(view);
			f.addKeyListener(view);
			f.setSize(1000, 1000);
			f.setLocation(100, 100);
			f.pack();
			f.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * getInstance method for the purposes of the singleton patern
	 * @return A new instance of GameWindow
	 */
	public static GameWindow getIntance() {
		if(gameInstance == null) {
			gameInstance = new GameWindow();
		}
		
		return gameInstance;
	}
}