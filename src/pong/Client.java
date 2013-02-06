package pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Client extends JFrame implements ActionListener, Commons {
	private Timer timer;
	private Game game;
	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private PrintWriter writer;
	private Scanner reader;
	
	public Client(String hostname){
		try {
			socket = new Socket(hostname, PORT);
			input = socket.getInputStream();
			output = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		reader = new Scanner(input);
		writer = new PrintWriter(output);
		game = new Game(CLIENT_STARTING_POSITION);
		add(game);
		timer = new Timer(CLIENT_SPEED, this);
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		writer.println(game.getNetMove());
		game.update(new GameInfo(reader.nextDouble(), reader.nextDouble(), reader.nextDouble(), reader.nextDouble(), reader.nextDouble(), reader.nextDouble()));
	}
	

}
