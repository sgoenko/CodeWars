package BouncingBall;

public class BouncingBall {
	public static int bouncingBall(double h, double bounce, double window) {
	  
		if (!(h>0 && bounce>0 && bounce<1 && window<h))
			return -1;
		double curH = h;
		int num = 1;
		while(curH*bounce > window) {
			curH *= bounce;
			num += 2;
		}
		return num;
	}
	
	public static void main(String[] args) {
	      System.out.println(BouncingBall.bouncingBall(3.0, 0.66, 1.5));
	      System.out.println(BouncingBall.bouncingBall(30.0, 0.66, 1.5));
	}
}
