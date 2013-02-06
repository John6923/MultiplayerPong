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
	
	private double	 serverX = SERVER_START_X, 
					serverY = SERVER_START_Y, 
					clientX = CLIENT_START_X, 
					clientY = CLIENT_START_Y, 
					ballX = BALL_START_X, 
					ballY = BALL_START_Y, 
					ballDir = BALL_START_Y;
	
	public Server(){
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
		//TODO add ball collision
		writer.println(clientX);
		writer.println(clientY);
		writer.println(serverX);
		writer.println(serverY);
		writer.println(ballX);
		writer.println(ballY);
	}
}
