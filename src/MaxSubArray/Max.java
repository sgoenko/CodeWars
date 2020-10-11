package MaxSubArray;

public class Max {
	  public static int sequence(int[] arr) {
		  if (arr==null)
			  return 0;
		  
		  int max = 0;
		  
		  for(int i = 0; i< arr.length; i++) {
			  if (arr[i] > 0) {
				  int newMax = 0;
				  for(int j = i; j< arr.length; j++) {
					  newMax += arr[j];
					  if (newMax > max)
						  max = newMax;
				  }
			  }
				 
		  }
		  
		  return max;
	  }

      public static void main(String[] args) {
			System.out.println( Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	  }
}
