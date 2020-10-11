package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorMy {
	  public static Double evaluate(String expression) {
	    List<String>input = Arrays.asList(expression.split(" "));
	    if(input.size() ==1)
	    	return Double.parseDouble(expression);
	    
	    List<String>second = new ArrayList<String>();
	    
    	Double result = 0.0;
	    for(int i=0; i<input.size(); i++) {
   	
	    	if ((i < input.size()-2) && (input.get(i+1).compareTo("*") == 0) ) {
	    			result = Double.parseDouble(input.get(i)) * Double.parseDouble(input.get(i+2));
	    			i+=2;
	    	}
	    	else if ((i < input.size()-2) && (input.get(i+1).compareTo("/") == 0) ) {
	    			result = Double.parseDouble(input.get(i)) / Double.parseDouble(input.get(i+2));
	    			i+=2;
	    	}
	    	else if ((i<input.size()-1) && (input.get(i).compareTo("*") == 0)) {
    			result *= Double.parseDouble(input.get(i+1));
    			i++;
    		}
    		else if ((i<input.size()-1) && (input.get(i).compareTo("/") == 0)) {
    			result /= Double.parseDouble(input.get(i+1));
    			i++;
    		}
    		else {
    			if (result != 0.0) {
    				second.add(result.toString());
    				result = 0.0;
    			}
    			second.add(input.get(i));
    		}
	    }
	    
	    if (second.size() <= 1)
	    	return result;

	    if (second.size() %2 == 0)
			second.add(result.toString());
	    
	    result = 0.0;
	    for(int i=0; i<second.size(); i++) {
    		if ((i < second.size()-2) && second.get(i+1).compareTo("+") == 0 ) {
    			result = Double.parseDouble(second.get(i)) + Double.parseDouble(second.get(i+2));
    			i+=2;
    		}
    		else if ((i < second.size()-2) && second.get(i+1).compareTo("-") == 0 ) {
    			result = Double.parseDouble(second.get(i)) - Double.parseDouble(second.get(i+2));
    			i+=2;
    		}
    		else if ((i < second.size()-1) && second.get(i).compareTo("+") == 0) {
	    			result += Double.parseDouble(second.get(i+1));
	    			i++;
	    		}
	    	else if ((i < second.size()-1) && second.get(i).compareTo("-") == 0) {
	    			result -= Double.parseDouble(second.get(i+1));
	    			i++;
	    		}
	    	
	    }
	    return result;
	  }
	  
	  public static void main(String[] args) {
		System.out.println(CalculatorMy.evaluate("2 / 2 + 3 * 4"));
	  }
	}