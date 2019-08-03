package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

public class Stick {
	
	public int x;
	public int y;
	
	public int w;
	public int h;
	
	public int x_hit_good;
	public int y_hit_good;
	public int w_hit_good;
	public int h_hit_good;
	
	public int x_hit_bad_TOP;
	public int y_hit_bad_TOP;
	public int w_hit_bad_TOP;
	public int h_hit_bad_TOP;
	
	public int x_hit_bad_BOT;
	public int y_hit_bad_BOT;
	public int w_hit_bad_BOT;
	public int h_hit_bad_BOT;
	
	Color color = Color.white;
	Color color_hitbox = Color.magenta;
	Color color_hitbox_bad = Color.cyan;	
	boolean dashUP = false;
	boolean dashDOWN = false;
		
	int speed = 2;
	
	// debug mode will handle hitboxes showing up etc...
	boolean debug = true;
	boolean ai;
	HashMap<Integer, String> aiMap = new HashMap<Integer, String>();
	HashMap<Integer, String> nameMap = new HashMap<Integer, String>();
	
	// an id of zero means its player 1 on the left
	// an id of one means its player 2 on the right
	int id;
	String skill;
	
	String name;
	
	public Stick (int x, int y, int id) {
		
		this.x = x;
		this.y = y;
		
		this.w = 16;
		this.h = 48;
		
		this.prepareMaps();
		
		// extract the id from the argument...
		this.id = id;
	
		if (id >= 100) {
			
			this.ai = true;
			this.skill = this.aiMap.get(this.id);
			this.name = this.nameMap.get(this.id);
		} else {
			this.ai = false;
		}
		
		
		this.skill = this.aiMap.get(this.id);
	
	// end of the Stick constructor
	}
	
	public void prepareMaps() {
	
		nameMap.put(100, "N00B");
		nameMap.put(200, "INTERMEDIATE");
		nameMap.put(300, "PRO");
		nameMap.put(400, "HACKER");
		
		aiMap.put(100, "EASY");
		aiMap.put(200, "MEDIUM");
		aiMap.put(300, "HARD");
		aiMap.put(400, "IMPOSSIBLE");
	}
	
	private void handleAI() {
		// force medium
		switch ( this.id) {

			case (100):
				n00b();
			break;
			
			case (200):
				medium();
			break;
			
			case (300):
				hard();
			break;
			
			case (400):
				impossible();
			break;
		}
	
	// end of the handleAi method
	}
	public void n00b () {
		
		int dir = (int) (Math.random() * 1000);
		
		if ( this.y > Game.windowHeight) this.y = 20 ;

		if ( this.y < 0) this.y = 480;
		
		if ( !this.dashDOWN && !this.dashUP) this.dashUP = true;
		
		if (dir > 937) {
			if (dir > 960) {
				this.dashDOWN = true;
				this.dashUP = false;
			} else {
				this.dashDOWN = false;
				this.dashUP = true;
			}
		}
	}
	// end of n00b AI
public void hard() {
			
		// 1.A -> Has the stick exceeded the top ?
		if (this.y < 0) {
			
			this.dashUP = false;
			this.dashDOWN = true;

		}
		// 1.B -> Is the stick too far down ?
		if (this.y > 520) {
			this.dashUP = true;
			this.dashDOWN = false;
		}
		
		//2.A -> Create integers to store the ball center and the stick center
		int ballCenter = Game.ball.y + (Game.ball.h / 2);
		int stickCenter = this.y + (this.h / 2);
		
		if ( this.debug ) System.out.println("My y position is: " + this.y);
		
		//2.B -> DISTANCE
		int dist = Math.abs( stickCenter - ballCenter );
				
		if (this.debug ) System.out.println("The y distance to the ball is: " + dist);
		
		System.out.println("The distance to the ball is: " + dist);
		System.out.println("My y position is: " + y);
		// 3.A. -> If the Distance in terms of y positions is greater than the height of the stick
		if ( dist > 4) {
			
			if ( ballCenter < stickCenter) {
				this.dashUP = true;
				this.dashDOWN = false;
			} else if ( ballCenter > stickCenter ){
				this.dashDOWN = true;
				this.dashUP = false;
			} else {
				this.dashDOWN = false;
				this.dashUP = false;
			}
		} else {
			this.dashUP = false;
			this.dashDOWN = false;
		}
		
		
	// end the hard AI algorithm
	}
	// handle impossible AI
	public void impossible() {

		//1.A -> Create integers to store the ball center and the stick center... MACHINE LEARNING
		int ballCenter = Game.ball.y + (Game.ball.h / 2);
		int stickCenter = this.y + (this.h / 2);
		
		// 1.B -> DISTANCE
		int dist = Math.abs( stickCenter - ballCenter );		
		
		// 2.A -> Move the AI stick if the ball is lower
		if ( Game.ball.y > stickCenter) {
			
			// 2.B -> IMPOSSIBLE AI CHEATER
			if (Game.ball.vx > 0 && dist < 32) {
				this.h++;
				
				
			// 2.C -> Just move...
			} else {
				
				this.y++;
			}
		//2.D -> Simply move up.
		} else {
			
			this.y--;
		}

		
		if ( dist > this.h && Game.ball.vx < 0 && this.h > 32) {
			
			this.h--;
			
		}
	// end of impossible
}
	
	public void medium() {
		
		// 1.A -> Has the stick exceeded the top ?
		if (this.y < 0) {
			
			this.dashUP = false;
			this.dashDOWN = true;

		}
		// 1.B -> Is the stick too far down ?
		if (this.y > 520) {
			this.dashUP = true;
			this.dashDOWN = false;
		}
		
		//2.A -> Create integers to store the ball center and the stick center...
		int ballCenter = Game.ball.y + (Game.ball.h / 2);
		int stickCenter = this.y + (this.h / 2);
		
		if ( this.debug ) System.out.println("My y position is: " + this.y);
		int dist = Math.abs(this.y + (this.h / 2))- Game.ball.y + (int)(Game.ball.h / 2);
		
		System.out.println("The distance to the ball is: " + dist);
		System.out.println("My y position is: " + y);
		// 3.A. -> If the Distance in terms of y positions is greater than the height of the stick
		if ( dist > this.h ) {
			
			if ( ballCenter < stickCenter) {
				this.dashUP = true;
				this.dashDOWN = false;
			} else if ( ballCenter > stickCenter ){
				this.dashDOWN = true;
				this.dashUP = false;
			} else {
				this.dashDOWN = false;
				this.dashUP = false;
			}
		}
		
		
	// end the medium AI algorithm
	}

	
	public void update() {
		
		//System.out.println("I'm updating");
		
		System.out.println(this.dashUP);
		
		if ( this.dashUP ) this.y -= this.speed;
		
		if ( this.dashDOWN ) this.y += this.speed;
		
		if ( this.id == 0) {
			
			this.x_hit_good = this.x + 8;
			
			

		} else {
			
			// player 1 hitbox...
			this.x_hit_good = this.x;
			
			if (this.id >= 100) {
				this.handleAI();
			}
		}
		
		// this happens by default
		this.y_hit_good = this.y + 4;
		this.w_hit_good = 8;
		this.h_hit_good = this.h - 8;
		
		// yeetrium
		this.x_hit_bad_TOP = this.x;
		this.y_hit_bad_TOP = this.y;
		this.w_hit_bad_TOP = 16;
		this.h_hit_bad_TOP = 4;
		
		this.x_hit_bad_BOT = this.x;
		this.y_hit_bad_BOT = this.y + this.h - 4;
		this.w_hit_bad_BOT = 16;
		this.h_hit_bad_BOT = 4;
		
	// end the update method...
	}
	
	public void draw(Graphics g) {
		
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.w, this.h);
		
		// debug
		if (this.debug) {
			
			g.setColor(this.color_hitbox);
			
			
					
			// GOOD HITBOX....
			g.setColor(this.color_hitbox);
			g.fillRect(this.x_hit_good, this.y_hit_good, this.w_hit_good, this.h_hit_good);
			
			// bad hitbox
			g.setColor(this.color_hitbox_bad);
			g.fillRect(this.x_hit_bad_TOP, this.y_hit_bad_TOP, this.w_hit_bad_TOP, this.h_hit_bad_TOP);
			// bad hitbox for bottom...
			g.fillRect(this.x_hit_bad_BOT, this.y_hit_bad_BOT, this.w_hit_bad_BOT, this.h_hit_bad_BOT);

	
		}
		
		if( this.ai ) {
			g.setColor((Color.WHITE));
			g.drawString(this.name, this.x - 16, this.y - 6);
		}
		
		// draw the hitbox
		
	}	
		
// end of the stick
// SUBSCRIBE TO PEWDIEPIE
// UNSUBSCRIBE FROM T-SERIES
}
