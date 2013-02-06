package pong;

@SuppressWarnings("serial")
public class YouLose extends GameResult implements Commons {
	
	public YouLose(){
		super(YOU_LOSE_TITLE,YOU_LOSE_TEXT);
	}

}
