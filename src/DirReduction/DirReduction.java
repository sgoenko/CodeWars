package DirReduction;

import java.util.Stack;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
	    Stack<String> s = new Stack<>();
	    
	    for (String cur : arr) 
	    	if (s.size() > 0 && isZero(s.peek(), cur)) s.pop(); 
	    	else s.push(cur);

	    return s.stream().toArray(String[]::new);
    }

	public static boolean isZero(String x, String y) {
	    return  (x == "NORTH" && y == "SOUTH") ||
	    		(x == "SOUTH" && y == "NORTH") ||
	    		(x == "WEST" && y == "EAST") ||
	    		(x == "EAST" && y == "WEST");
	}
	
    public static void main(String[] args) {
    	String[] result =
    			DirReduction.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"});
    	for (String s: result)
    		System.out.println(s);
    }
	
}