package pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Server extends JFrame implements ActionListener, Commons {
	private Timer timer;
	private Game game;
	private ServerSocket server;
	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private PrintWriter writer;
	private Scanner reader;
	
	private double	serverX = SERVER_START_X, 
					serverY = SERVER_START_Y, 
					clientX = CLIENT_START_X, 
					clientY = CLIENT_START_Y, 
					ballX = BALL_START_X, 
					ballY = BALL_START_Y, 
					ballDir = BALL_START_Y;
	
	public Server(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);
		try {
			server = new ServerSocket(PORT);
			socket = server.accept();
			input = socket.getInputStream();
			output = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		reader = new Scanner(input);
		writer = new PrintWriter(output);
		game = new Game(SERVER_STARTING_POSITION);
		add(game);
		timer = new Timer(SERVER_SPEED, this);
		timer.start();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.stop();
		double clientMovement = reader.nextDouble();
		double serverMovement = game.getNetMove();
		clientY = clientMovement * PADDLE_SPEED;
		serverY = serverMovement * PADDLE_SPEED;
		ballX += Math.cos(Math.toRadians(ballDir));
		ballY += Math.sin(Math.toRadians(ballDir));
		if(ballY > GAME_HEIGHT || ballY < 0){
			verticalBallBounce();
		}
		if(ballX < 0){
			if(ballTouchingPaddle(serverY)){
				ballBounceRight();
			}
			else{
				youLose();
				return;
			}
		}
		if(ballX > GAME_WIDTH){
			if(ballTouchingPaddle(clientY)){
				ballBounceLeft();
			}
			else{
				youWin();
				return;
			}
		}
		writer.println(false);
		writer.println(clientX);
		writer.println(clientY);
		writer.println(serverX);
		writer.println(serverY);
		writer.println(ballX);
		writer.println(ballY);
		
		timer.start();
	}
	
	private void verticalBallBounce(){
		ballDir *= -1;
	}
	
	private boolean ballTouchingPaddle(double y){
		if(ballY > y || ballY < y + PADDLE_HEIGHT) return true;
		return false;
	}
	
	private void ballBounceRight(){
		ballDir = (((ballDir - 90) * -1) + 90);
	}
	
	private void youLose(){
		cleanup();
		new YouLose();
	}
	
	private void ballBounceLeft(){
		ballDir = (((ballDir - 90) * -1) + 90);
	}
	
	private void youWin(){
		cleanup();
		new YouWin();
	}
	
	private void cleanup(){
		try{
			output.close();
			input.close();
			socket.close();
			server.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		setVisible(false);
	}
}
