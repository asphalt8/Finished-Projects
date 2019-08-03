package main;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game {

	// ROBLOX
	// XOLBOR
	// ROBLOX
	// XOLBOR
	static JFrame frame;
	public static DrawWindow drawPanel;
	// R X R X
	// O O O O
	// B L B L
	// L B L B
	// O O O O
	// X R X R
	private int windowWidth = 896;
	public static int windowHeight = 612;
	
	JLabel label;
	
	// make a stick
	public static Stick player1 = new Stick(32, 256, 0);
	public static Stick player2 = new Stick(800, 256, Utility.generateAI());
	
	// make a ball
	public static Ball ball = new Ball();
	
	// begin the main method
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// IMPORTANT: Make your game widow etc...
		new Game(). prepareGui();
		
	}

	// This function of prepareGui -> handles much of the "Window preparation"
	private void prepareGui() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		frame = new JFrame("PONG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		drawPanel = new DrawWindow();
		
		frame.getContentPane().add( BorderLayout.CENTER, drawPanel );
		frame.setResizable(false);
		
		drawPanel.setFocusable(true);
		drawPanel.requestFocusInWindow();
		
		// IMPORTANT: frame setup
		frame.setSize(windowWidth, windowHeight);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
		// link the input system to the game...
		PlayerInput.prepareInput();
		
		// update your game
		update();
	}
	
	
	// ROBLOX XOLBOR ROBLOX XOLBOR
	private void update() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		while (true) {
			
			// update da playerz
			player1.update();
			player2.update();
			
			//update the ball
			ball.update();
			
			// IMPORTANT!!!!
			// important thread data
			try {
				Thread.sleep(10);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			frame.repaint();
			
		}
	}
}
