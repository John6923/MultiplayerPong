package pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Game extends JPanel {
	
	private boolean up = false, down = false;
	
	private GameInfo game;
	
	public Game(){
		addKeyListener(new KeyHandler());
	}
	
	public void update(GameInfo g){
		
	}
	
	private class KeyHandler extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				up = true;
				break;
			case KeyEvent.VK_DOWN:
				down = true;
				break;
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				up = false;
				break;
			case KeyEvent.VK_DOWN:
				down = false;
				break;
			}
		}
	}
}
