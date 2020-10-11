package cw;

import java.util.ArrayList;
import java.util.List;

public class RemovedNumbers {
	
	public static List<long[]> removNb(long n) {
	    List<long[]> result = new ArrayList<long[]>();
	    long sum = n * (n + 1) / 2;
	    
	    for (long x = 1; x <= n; x++) {
	      long y = (sum - x) / (x + 1);
	      if (y <= n && x * y == sum - x - y) {
	        result.add(new long[] {x, y});
	      }
	    }
	    return result;
	  }
	
	public static void main(String[] args) {
		System.out.println(removNb(1000003));
	}
}

