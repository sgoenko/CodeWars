package screen.lock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreenLock {
	private Map<Character, char[]> basicTransitions = new HashMap<>() {{
			put('A', new char[]{'B','D','E','F','H'});
			put('B', new char[]{'A','C','D','E','F','G','I'});
			put('C', new char[]{'B','D','E','F','H'});
			put('D', new char[]{'A','B','C','E','G','H','I'});
			put('E', new char[]{'A','B','C','D','F','G','H','I'});
			put('F', new char[]{'A','B','C','E','G','H','I'});
			put('G', new char[]{'B','D','E','F','H'});
			put('H', new char[]{'A','C','D','E','F','G','I'});
			put('I', new char[]{'B','D','E','F','H'});
	}};
	
	private Map<String, Character> additionTransitions = new HashMap<>() {{
			put("AB", 'C'); put("AD", 'G'); put("AE", 'I');
			put("BE", 'H');
			put("CB", 'A'); put("CE", 'G'); put("CF", 'I');
			put("DE", 'F');
			put("FE", 'D');
			put("GD", 'A');	put("GE", 'C');	put("GH", 'I');
			put("HE", 'B');
			put("IE", 'A');	put("IF", 'C');	put("IH", 'G');

	}};
	
	private boolean[] visitedNodes = { 
			false, false, false, 
			false, false, false, 
			false, false, false };

	public int calculateCombinations(char startPosition, int patternLength) {
		int numberOfCombinations = 0;

		if (patternLength > 9 || patternLength < 1)
			return 0;
		if (patternLength == 1)
			return 1;

		setVisited(startPosition);

		char[] levelNodes = basicTransitions.get(startPosition);
		
		List<Character> currentTransitions = new ArrayList<>();
		
		for (Character ch : levelNodes) {
			if (isNotVisited(ch)) {
				currentTransitions.add(ch);
			}
		}
		
		for (int i = 0; i < visitedNodes.length; i++) {
			if (visitedNodes[i]) {
				Character ch = (char) ('A' + i);
				String missed =  ""+ startPosition + ch;
				if (additionTransitions.containsKey(missed)) {
					Character addition = additionTransitions.get(missed);
					if (isNotVisited(addition)) {
						currentTransitions.add(addition);
					}
				}
			}
		}
		
		if (currentTransitions.isEmpty()) {
			setUnvisited(startPosition);
			return 0;
		}
		
		for (Character ch : currentTransitions) {
			numberOfCombinations += calculateCombinations(ch, patternLength - 1);
		}

		setUnvisited(startPosition);
		
		return numberOfCombinations;
	}

	private boolean isNotVisited(Character ch) {
		return !visitedNodes[ch - 'A'];
	}

	private void setVisited(Character ch) {
		visitedNodes[ch - 'A'] = true;
	}

	private void setUnvisited(Character ch) {
		visitedNodes[ch - 'A'] = false;
	}

}