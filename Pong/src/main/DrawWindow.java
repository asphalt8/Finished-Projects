package main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class DrawWindow extends JPanel {

	/**
	 * 
	 */
	
	
	public void paintComponent(Graphics g) {
		
		// Default to BLACK background if there is a problem loading the BG image
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// draw the middle line
		g.setColor(Color.WHITE);
		g.fillRect(this.getWidth() / 2 - 4, 0, 8, this.getHeight());
		
		// draw the players
		Game.player1.draw(g);
		Game.player2.draw(g);
		
		// draw the ball
		Game.ball.draw(g);
	}
	
}
