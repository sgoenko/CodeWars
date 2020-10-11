package Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstParser {
	
	public static int parseInt(String numStr) {
		System.out.println(numStr);
		Map<String, Integer> map = Stream.of(new Object[][]{
		     {"zero",0},{"one",1},{"two",2},{"three",3},{"four",4},{"five",5},{"six",6},
		     {"seven",7},{"eight",8},{"nine",9},{"ten",10},{"eleven",11},{"twelve",12},
		     {"thirteen",13},{"fourteen",14},{"fifteen",15},{"sixteen",16},
		     {"seventeen",17},{"eighteen",18},{"nineteen",19},
		     {"twenty",20}, {"thirty",30}, {"forty",40}, {"fifty",50}, {"sixty",60}, 
		     {"seventy",70}, {"eighty",80}, {"ninety",90}})
			 .collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
	    
		 Map<String, Integer> multiMap = Stream.of(new Object[][]{
			 {"hundred",100}, {"thousand",1000}, {"million",1000000}})
				 .collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
		
		List<String> input = new ArrayList<String>(Arrays.asList(numStr.split(" ")));
		
		int result = 0, result2 = 0;
		
		for (String number: input) {
			if (multiMap.containsKey(number)) {
				result *= multiMap.get(number);
				if (result >= 1000) {
			        result2 = result;
			        result = 0;
			    }
			} 
			else if(number.compareTo("and") != 0) {
			    String[] compountNumber = number.split("-");
			    if (compountNumber.length > 1) {
			    	result += map.get(compountNumber[0]) + map.get(compountNumber[1]);
			    }
			    else {
			    	result += map.get(number);
			    }
			}
		}
		  
		return result + result2;
	}
	
//	public static void main(String[] args) {
//		System.out.println(Parser.parseInt("one hundred"));
//		System.out.println(Parser.parseInt("one hundred one"));
//		System.out.println(Parser.parseInt("one hundred and one"));
//	}
}


