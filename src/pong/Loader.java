package pong;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Loader extends JFrame implements Commons{
	
	private JLabel serverLabel = new JLabel();
	private JButton serverButton = new JButton(SERVER_BUTTON_LABEL);
	private JTextArea clientLabel = new JTextArea(CLIENT_LABEL);
	private JButton clientButton = new JButton(CLIENT_BUTTON_LABEL);
	
	
	public Loader(){
		setSize(LOADER_WIDTH,LOADER_HEIGHT);
		setTitle(LOADER_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(2,2,5,5));
		try {
			serverLabel.setText((InetAddress.getLocalHost()).getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		serverButton.addActionListener(new ServerHandler());
		serverButton.addActionListener(new ClientHandler());
		c.add(serverLabel);
		c.add(serverButton);
		c.add(clientLabel);
		c.add(clientButton);
		setVisible(true);
		
	}
	
	private class ServerHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new Server();
		}
	}
	
	private class ClientHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new Client(clientLabel.getText());
		}
	}
	
	public static void main(String[] args) {
		new Loader();
	}

}
