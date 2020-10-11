package pin;

import java.util.ArrayList;
import java.util.List;

public class ObservedPin {

	public static List<String> getPINs(String observed) {
		String neighbours[] = { "08", "124", "1235", "236", "1457", "24568", "3569", "478", "05789", "689" };
		List<String> result = new ArrayList<String>();
		
		for (char ch: observed.toCharArray()) {
			int i = Character.getNumericValue(ch);
			result = crossJoin(result, neighbours[i]);
		}
		return result;
	}
	
	public static List<String> crossJoin(List<String> A, String B){
		List<String> result = new ArrayList<String>();
		  
		if  (A.isEmpty()){
			for (String s : B.split("")) 
			    result.add(s);
			return result;
		}
		
		for (int i=0 ; i <A.size(); i++){
		    for (int j=0; j<B.length(); j++){
		      result.add(A.get(i) + B.substring(j, j+1));
		    }
		}
		return result;
	}	
		
	public static void main(String[] args) {
		System.out.println(getPINs("8"));
	}
}

