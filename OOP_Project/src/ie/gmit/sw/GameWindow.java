package ie.gmit.sw;

import java.awt.*;
import javax.swing.*;

public class GameWindow {
	/*
	 * This matrix represents the isometric game model, with each number mapping to an
	 * image in the images/ground/ directory.
	 */
	public static final int DEFAULT_VIEW_SIZE = 1280;
	
	//This matrix is a representation of where objects (things) in the game are placed
	private int[][] objects = { 
			{ 0, 0, 0, 0, 0, 5 , 5, 11, 5, 0},
			{ 5, 0, 0, 0, 0, 5 , 5, 5, 5, 0},
			{ 5, 5, 0, 0, 0, 5 , 5, 5, 5, 9},
			{ 5, 5, 2, 0, 0, 0 , 5, 5, 5, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 5, 5, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 5, 0},
			{ 0, 0, 0, 0, 0, 3 , 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
			{ 1, 6, 0, 0, 0, 0 , 0, 0, 0, 10}
	};
	
	public static GameWindow gameInstance = null;
	
	public GameWindow(){
		try {
			GameView view = new GameView(objects);
			Dimension d = new Dimension(DEFAULT_VIEW_SIZE, DEFAULT_VIEW_SIZE/2);
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
	
	public static GameWindow getIntance() {
		if(gameInstance == null) {
			gameInstance = new GameWindow();
		}
		
		return gameInstance;
	}
}