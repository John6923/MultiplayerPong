package pong;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GameResult extends JFrame implements Commons {
	
	public JLabel textArea;
	
	public GameResult(String title, String text){
		setSize(RESULT_WIDTH,RESULT_HEIGHT);
		setTitle(title);
		textArea = new JLabel(text);
		add(textArea);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
