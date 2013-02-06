package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel implements Commons, GraphicsCommons{
	
	private boolean up = false, down = false;
	
	private GameInfo game;
	
	public Game(GameInfo game){
		addKeyListener(new KeyHandler());
		setBackground(Color.black);
		this.game = game;
	}
	
	public void update(GameInfo g){
		this.game = g;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g1) {
		super.paintComponent(g1);
		Graphics2D g = (Graphics2D) g1;
		//DrawMe
		g.setColor(MY_COLOR);
		g.fillRect((int)game.getMyX(), (int)game.getMyY() - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT);
		//DrawYou
		g.setColor(YOUR_COLOR);
		g.fillRect((int)game.getYourX(), (int)game.getYourY() - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT);
		//DrawBall
		g.setColor(BALL_COLOR);
		g.fillOval((int)game.getBallX() - BALL_RADIUS, (int)game.getBallY() - BALL_RADIUS, 2* BALL_RADIUS , 2 * BALL_RADIUS);
		//Cleanup
		g.dispose();
		g1.dispose();
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
	

	public double getNetMove(){
		return (up ? UP : STILL) + (down ? DOWN : STILL);
	}
}
