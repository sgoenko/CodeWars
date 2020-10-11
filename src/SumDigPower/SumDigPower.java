package SumDigPower;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {
    public static List<Long> sumDigPow(long a, long b) {
        List<Long>list = new ArrayList<Long>();
        
        for(long i = a; i<=b; i++) {
            String s = Long.toString(i);
            long cur = 0;
            for (int j=0; j<s.length(); j++) {
            	cur += Math.pow(Character.getNumericValue(s.charAt(j)), j+1);
            }
            if (cur == i)
            	list.add(i);
        }
        return list;
    }
    
    public static void main(String[] args) {
    	System.out.println(sumDigPow(1,10));
/*    	testing(1, 10, new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        testing(1, 100, new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 89});
        testing(10, 100,  new long[] {89});
        testing(90, 100, new long[] {});
        testing(90, 150, new long[] {135});
        testing(50, 150, new long[] {89, 135});
        testing(10, 150, new long[] {89, 135});*/
    
    }
}
