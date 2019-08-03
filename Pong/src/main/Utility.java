package main;

public class Utility {
	
	// good stick
	public static boolean hitStick(Stick stick, Ball ball) {
		

		
		if ((stick.x_hit_good < ball.x + ball.w) &&
			(stick.x_hit_good + stick.w_hit_good > ball.x) &&
			(stick.y_hit_good < ball.y + ball.h) &&
			(stick.h_hit_good + stick.y_hit_good > ball.y) ) {
			
			return true;
		} else {
			return false;
		}
	}
	
	// bad stick
		public static boolean hitStickBad(Stick stick, Ball ball) {
			

			
			if ((stick.x_hit_bad_TOP < ball.x + ball.w) &&
				(stick.x_hit_bad_TOP + stick.w_hit_bad_TOP > ball.x) &&
				(stick.y_hit_bad_TOP < ball.y + ball.h) &&
				(stick.h_hit_bad_TOP + stick.y_hit_bad_TOP > ball.y) ) {
				
				return true;
			} else if ((stick.x_hit_bad_BOT < ball.x + ball.w) &&
					(stick.x_hit_bad_BOT + stick.w_hit_bad_BOT > ball.x) &&
					(stick.y_hit_bad_BOT < ball.y + ball.h) &&
					(stick.h_hit_bad_BOT + stick.y_hit_bad_BOT > ball.y) ) {
				return true; 
			}
				
			
			else {
				return false;
			}
		}
	
	public static int generateAI ( ) {
		
		return (int) (Math.random()* 4) * 100 + 100;
	}
	
}
