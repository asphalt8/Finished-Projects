package main;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

public class PlayerInput {

	public static void prepareInput () {
		
		Game.drawPanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "W_DOWN");
		Game.drawPanel.getActionMap().put("W_DOWN", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3072622280177926005L;

			public void actionPerformed(ActionEvent e) {
				System.out.println("W_DOWN");
				Game.player1.dashUP = true;
				
				
			}
		});
		
		Game.drawPanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "W_UP");
		Game.drawPanel.getActionMap().put("W_UP", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2185376432430782164L;

			public void actionPerformed(ActionEvent e) {
				System.out.println("W_UP");
				Game.player1.dashUP = false;
				
				
			}
		});
		
		Game.drawPanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "S_DOWN");
		Game.drawPanel.getActionMap().put("S_DOWN", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3072622280177926005L;

			public void actionPerformed(ActionEvent e) {
				System.out.println("S_DOWN");
				Game.player1.dashDOWN = true;
				
				
			}
		});
		
		Game.drawPanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "S_UP");
		Game.drawPanel.getActionMap().put("S_UP", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2185376432430782164L;

			public void actionPerformed(ActionEvent e) {
				System.out.println("S_UP");
				Game.player1.dashDOWN = false;
				
				
			}
		});
		
		// begin player dos
		
		Game.drawPanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "UP_PRESSED");
		Game.drawPanel.getActionMap().put("UP_PRESSED", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3072622280177926005L;

			public void actionPerformed(ActionEvent e) {
				System.out.println("UP_PRESSED");
				
			if (Game.player2.id == 1) {
				Game.player2.dashUP = true;
			}
				
			}
		});
		
		Game.drawPanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "UP_RELEASED");
		Game.drawPanel.getActionMap().put("UP_RELEASED", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2185376432430782164L;

			public void actionPerformed(ActionEvent e) {
				System.out.println("UP_RELEASED");
			if (Game.player2.id == 1) {			
				Game.player2.dashUP = false;
			}
				
			}
		});
		
		Game.drawPanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "DOWN_PRESSED");
		Game.drawPanel.getActionMap().put("DOWN_PRESSED", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3072622280177926005L;

			public void actionPerformed(ActionEvent e) {
				System.out.println("DOWN_PRESSED");
			if (Game.player2.id == 1) {			
				Game.player2.dashDOWN = true;
			}
				
			}
		});
		
		Game.drawPanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "DOWN_RELEASED");
		Game.drawPanel.getActionMap().put("DOWN_RELEASED", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2185376432430782164L;

			public void actionPerformed(ActionEvent e) {
				System.out.println("DOWN_RELEASED");
			if (Game.player2.id == 1) {				
				Game.player2.dashDOWN = false;
			}	
				
			}
		});

	}
}
