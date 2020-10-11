package PerfectPower;

public class PerfectPower {
	  public static int[] isPerfectPower(int n) {
		  
		  int sqr = (int) Math.sqrt(n) + 1;
		  
		  int curPow = 0;
		  for (int j=sqr; j>1; j--) {
			  for (int i=2; i<= sqr && curPow<n; i++) {
				  curPow = pow(j,i);
				  if (curPow == n) {
				  	  return new int[] {j,i};
				  }
			  }
		  }
		  return null;
	  }
	  
	  public static int pow(int value, int pow) {
		   if (pow == 1) {
		       return value;
		   } else {
		       return value * pow(value, pow - 1);
		   }
		}
	  
	  public static void main(String[] args) {
		    isPerfectPower(484);
			
	}		  
}