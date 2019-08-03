package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Ball {

	int x = 448;
	int y = 256;
	
	int vx;
	int vy;
	int w = 16;
	int h = 16;
	
	Color color = Color.WHITE;
	
	// attempt to set font
	Font myFont = new Font ("Courier", 1, 17);
	
	boolean dead = false;
	
	int scoreLeft = 0;
	int scoreRight = 0;
	
	public Ball() {
		
		this.randomizeVX();
		
		
	}
	
	public void randomizeVX( ) {
		
		this.vx = (int ) ( Math.random() * 4) -2;
		this.vy = (int ) ( Math.random() * 4) -2;
		
		// in the case of a boring ball...
		// call the function again :D
		if ( this.vx == 0) 
			this.randomizeVX();
			
		// revive the ball
		this.dead = false;
		this.color = Color.white;
		
	}
	
public void draw(Graphics g) {
		
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.w, this.h);
		
		if ( Game.player2.ai ) {
			g.setFont(this.myFont);
			g.setColor(Color.WHITE);
			g.drawString(" PLAYER 1: " + "" + this.scoreLeft, 64, 64);
			
			g.setFont(this.myFont);
			g.setColor(Color.WHITE);
			g.drawString(Game.player2.name + " : " + this.scoreRight, 500, 64);
		}
	}
	public void wallBounce() {
		// handle a wall bounce....
		if ( this.y > 596 - (this.h * 2) || this.y < 0) {
			
			this.vy *= -1;
		}
	}
	
	private void randomizeVY () {
		this.vy = ( int ) ( Math.random() * 4) - 2;
	}
	
	private void boostVX () {
		
		this.vx *= (int) ( Math.random() * 1) + 2;
	}
	public void update( ) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		// change the position of the ball...
		this.x += this.vx;
		
		if ( !this.dead) {
			
			// change y position
			this.y += this.vy;
			
			if ( Utility.hitStick(Game.player1, this) || Utility.hitStick(Game.player2, this) ) {
				
				/* play basic sound...
				Sound sound = new Sound("Randomize9");
				sound.start();
				*/
				//sound.stop();
				this.vx *= -1;
				
				this.randomizeVY();
				this.boostVX();
				
				if ( this.vx > 0) {
					this.x += 4;
				} else {
					this.x -= 4;
				}
			}
			
			else if ( Utility.hitStickBad(Game.player1, this) || Utility.hitStickBad(Game.player2, this) ) {
				
				this.color = Color.red;
				this.dead = true;
			}
			
		}
		
		// handle bouncing for the North and South walls
		this.wallBounce();
		
		
		
		
		
		if ( this.x > 896 ) {
			this.x = 448;
			this.y = 256;
			
			// player1 gets a point
			this.scoreLeft++;
			
			//randomize the velocity.. please :D
			this.randomizeVX();
		}
		
		if ( this.x < - 16) {
			
			this.x = 448;
			this.y = 256;
			
			// player2 gets a point
			this.scoreRight++;
			
			// randomize the velocity... MACHINE LEARNING
			this.randomizeVX();
		}
	}
}

