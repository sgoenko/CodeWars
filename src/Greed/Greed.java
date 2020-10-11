package Greed;

public class Greed{
	
	public static void main(String[] args) {
	      System.out.println(Greed.greedy(new int[]{5,1,3,4,1}));
	      System.out.println(Greed.greedy(new int[]{1,1,1,3,1}));
	      System.out.println(Greed.greedy(new int[]{2,4,4,5,4}));
	}

	public static int greedy(int[] dice){
	    int result = 0;
	    
	    int[] nums = new int[7];
	    for (int i:dice)
	    	nums[i]++;

	    result += nums[1]/3 * 1000 + nums[1]%3 *100;
	    result += nums[5]/3 * 500 + nums[5]%3 *50;

	    result += nums[2]/3 * 200;
	    result += nums[3]/3 * 300;
	    result += nums[4]/3 * 400;
	    result += nums[6]/3 * 600;
	    		
	    return result;
	 }
}