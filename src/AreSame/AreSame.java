package AreSame;
import java.util.Arrays;

public class AreSame {
	
	public static boolean comp(int[] a, int[] b) {
		
		if (a.length != b.length)
			return false;
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		for (int i=0; i<a.length; i++) {
			if (a[i] != (b[i] / a[i]))
				return false;
		}
		return true;
	}
	

	public static void main(String[] args) {
			int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
			int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
			System.out.println(AreSame.comp(a, b)); 
		
	}	
}

