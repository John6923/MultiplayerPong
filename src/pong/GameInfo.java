package pong;

public class GameInfo {
	
	private double mx, my, ux, uy, bx, by;
	
	public GameInfo(double mx, double my, double ux, double uy, double bx, double by){
		this.mx = mx;
		this.my = my;
		this.ux = ux;
		this.uy = uy;
		this.bx = bx;
		this.by = by;
	}
	
	public double getMyX(){
		return mx;
	}
	
	public double getMyY(){
		return my;
	}
	
	public double getYourX(){
		return ux;
	}
	
	public double getYourY(){
		return uy;
	}
	
	public double getBallX(){
		return bx;
	}
	
	public double getBallY(){
		return by;
	}
	
}
