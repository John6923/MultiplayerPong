package pong;

public interface Commons {
	public final String LOCALHOST = "localhost";
	public final int LOADER_WIDTH = 300;
	public final int LOADER_HEIGHT = 150;
	public final String LOADER_TITLE = "Multiplayer Pong Loader";
	public final String SERVER_BUTTON_LABEL = "Start Server >>>";
	public final String CLIENT_BUTTON_LABEL = "Start Client >>>";
	public final String CLIENT_LABEL  = "Server IP";
	public final int GAME_WIDTH = 500;
	public final int GAME_HEIGHT = 500;
	public final int PADDLE_OFF_WALL = 50;
	public final int PADDLE_WIDTH = 10;
	public final int PADDLE_HEIGHT = GAME_HEIGHT / 5;
	public final int BALL_RADIUS = 5;
	public final int SERVER_START_X = PADDLE_OFF_WALL;
	public final int SERVER_START_Y = GAME_HEIGHT / 2;
	public final int CLIENT_START_X = GAME_WIDTH - PADDLE_OFF_WALL;
	public final int CLIENT_START_Y = GAME_HEIGHT / 2;
	public final int BALL_START_X = GAME_WIDTH / 2;
	public final int BALL_START_Y = GAME_HEIGHT / 2;
	public final int BALL_START_DIRECTION = 45;
	public final GameInfo SERVER_STARTING_POSITION = new GameInfo((double)SERVER_START_X, (double) SERVER_START_Y, (double) CLIENT_START_X, (double) CLIENT_START_Y,(double) BALL_START_X, (double) BALL_START_Y);
	public final GameInfo CLIENT_STARTING_POSITION = new GameInfo((double) SERVER_START_Y, (double) CLIENT_START_X, (double)SERVER_START_X, (double) CLIENT_START_Y,(double) BALL_START_X, (double) BALL_START_Y);
	public final int PORT = 3400;
	public final int CLIENT_SPEED = 100;
	public final int SERVER_SPEED = CLIENT_SPEED / 2;
	public final int BALL_SPEED = 10;
	public final int PADDLE_SPEED = 10;
	public final double UP = -1;
	public final double DOWN = 1;
	public final double STILL = 0;
	public final int RESULT_WIDTH = 500;
	public final int RESULT_HEIGHT = 500;
	public final String YOU_WIN_TEXT = "You have won the game!";
	public final String YOU_WIN_TITLE = "You Win!";
	public final String YOU_LOSE_TEXT = "Unfortunatly, you have lost the game :(";
	public final String YOU_LOSE_TITLE = "You Lose.";
	
}
