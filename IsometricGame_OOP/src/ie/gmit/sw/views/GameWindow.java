package ie.gmit.sw.views;

import java.awt.*;
import javax.swing.*;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import ie.gmit.sw.LevelConstants;
import ie.gmit.sw.builder.LevelBuilder;
public class GameWindow {
	/*
	 * This matrix represents the isometric game model, with each number mapping to an
	 * image in the images/ground/ directory.
	 */
	//Abstract builder factory - Have "Ground builder" call "Builder" etc..
	/*private int[][] model = { 
			{ 0, 0, 0, 2, 0, 0 , 0, 0, 0, 2},
			{ 0, 0, 0, 2, 0, 0 , 0, 0, 0, 2},
			{ 0, 0, 0, 2, 0, 0 , 0, 0, 0, 2},
			{ 0, 0, 0, 2, 0, 0 , 0, 0, 0, 2},
			{ 2, 2, 2, 2, 1, 0 , 0, 0, 0, 2},
			{ 3, 3, 3, 3, 1, 1 , 1, 0, 0, 1},
			{ 5, 5, 5, 5, 3, 3 , 1, 0, 0, 1},
			{ 4, 4, 4, 4, 5, 5, 5, 5, 3, 0},
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
	};
	
	//This matrix is a representation of where objects (things) in the game are placed
	private int[][] objects = { 
			{ 0, 0, 0, 5, 5, 5 , 5, 5, 5, 0},
			{ 5, 0, 0, 0, 5, 5 , 5, 5, 5, 0},
			{ 5, 5, 0, 0, 0, 5 , 5, 5, 5, 9},
			{ 5, 5, 2, 0, 0, 0 , 5, 5, 5, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 5, 5, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 5, 0},
			{ 0, 0, 0, 0, 0, 3 , 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 10}
	};*/
	
	public static GameWindow gameInstance = null;
	
	public GameWindow(){
		try {
			GameView view = new GameView(new LevelBuilder().ground(), new LevelBuilder().things());
			Dimension d = new Dimension(LevelConstants.DEFAULT_VIEW_SIZE, LevelConstants.DEFAULT_VIEW_SIZE/2);
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