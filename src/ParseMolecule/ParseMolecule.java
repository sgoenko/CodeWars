package ParseMolecule;

import java.util.Map;
import java.util.Stack;
import java.util.HashMap;

class ParseMolecule {
    
    public static Map<String,Integer> getAtoms(String formula) {
    	if(Character.isLowerCase(formula.charAt(0)))
			throw (new IllegalArgumentException() );

    	String braces = new String("()");
    	for (char c : formula.toCharArray()) {
    		if (c == '(' || c==')' || c=='[' || c==']' || c=='{' || c=='}')
    			braces += String.valueOf(c);
    	}

    	if (!isValid(braces))
    		throw (new IllegalArgumentException() );
    		
        Map<String,Integer>targetMap = new HashMap<String,Integer>();
        
        int mult1 = 1;
        int mult2 = 1;  
        int mult3 = 1;
        
        int value;
        String element;
        
        for(int i=0; i<formula.length(); i++) {
        	char cur = formula.charAt(i);
        	char next = (i < formula.length()-1) ? formula.charAt(i+1) :' ';
        	
        	switch(cur) {
        	case '{': 
        		String nm = "";
        		
        		int index = formula.indexOf('}', i) + 1;
        		while (index < formula.length() && Character.isDigit(formula.charAt(index))) 
        			nm += String.valueOf(formula.charAt(index++));
        		
        		if (!nm.isEmpty())
        			mult1 = Integer.parseInt(nm);
        		
        		break;
        	case '}':mult1 = 1;
        		break;
        	case '[': 
        		nm = "";
        		
        		index = formula.indexOf(']', i)+1;
        		while (index < formula.length() && Character.isDigit(formula.charAt(index))) 
        			nm += String.valueOf(formula.charAt(index++));
        		
        		if (!nm.isEmpty())
        			mult2 = Integer.parseInt(nm);
        		
        		break;
        	case ']': mult2 = 1;
        			break;
        	case '(': 
        		nm = "";
        		index = formula.indexOf(')', i)+1;
        		while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
        			nm += String.valueOf(formula.charAt(index++));
        		}
        		if (nm.isEmpty())
        			mult3 = 1;
        		else
        			mult3 = Integer.parseInt(nm);
        		break;
        	case ')':mult3 = 1;
        		break;
        	}

        	if (Character.isUpperCase(cur) ) {
        		element = String.valueOf(cur);
        		if (Character.isLowerCase(next)) {
        			element += String.valueOf(next);
        			i++;
        		}

        		String nm = "";
        		while (i < formula.length()-1 && 
        				formula.charAt(i+1)>='0' && formula.charAt(i+1)<='9') {
        			nm += String.valueOf(formula.charAt(i+1));
        			i++;
        		}
        		if (nm.isEmpty())
        			value = 1;
        		else
        			value = Integer.parseInt(nm);
       		
            	value *= mult1*mult2*mult3;
            	
            	if(targetMap.containsKey(element)) 
            		value += targetMap.get(element);
            		     		
            	targetMap.put(element, value);
        		
        	}
        }
        
        return targetMap;
    }

	public static boolean isValid(String braces) {
	    Stack<Character> s = new Stack<>();
	    for (char c : braces.toCharArray()) 
	      if (s.size() > 0 && isClosing(s.peek(), c)) s.pop(); 
	      else s.push(c);
	    return s.size() == 0;
	  }
	  
	public static boolean isClosing(char x, char c) {
	    return (x == '{' && c == '}') || (x == '(' && c == ')') || (x == '[' && c == ']');
	}	
  
	public static void main(String[] args) {
		System.out.println(getAtoms("([MgO2]2)3"));
	}
	

}