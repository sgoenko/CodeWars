package screen.lock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScreenLock {
	private Map<Character, List<Character>> transitions = new HashMap<>();
	private Map<String, Character> additions = new HashMap<>();
	private boolean[] visitedNodes = { 
			false, false, false, 
			false, false, false, 
			false, false, false };
	
	public ScreenLock() {
		transitions.put('A', "BDEFH".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
		transitions.put('B', "ACDEFGI".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
		transitions.put('C', "BDEFH".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
		transitions.put('D', "ABCEGHI".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
		transitions.put('E', "ABCDFGHI".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
		transitions.put('F', "ABCEGHI".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
		transitions.put('G', "BDEFH".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
		transitions.put('H', "ACDEFGI".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
		transitions.put('I', "BDEFH".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));

		additions.put("AB", 'C');
		additions.put("AD", 'G');
		additions.put("AE", 'I');

		additions.put("BE", 'H');

		additions.put("CB", 'A');
		additions.put("CE", 'G');
		additions.put("CF", 'I');

		additions.put("DE", 'F');

		additions.put("FE", 'D');

		additions.put("GD", 'A');
		additions.put("GE", 'C');
		additions.put("GH", 'I');

		additions.put("HE", 'B');

		additions.put("IE", 'A');
		additions.put("IF", 'C');
		additions.put("IH", 'G');
	}

	public int calculateCombinations(char startPosition, int patternLength) {
		int numberOfCombinations = 0;

		if (patternLength > 9 || patternLength < 1)
			return 0;
		if (patternLength == 1)
			return 1;

		List<Character> levelNodes = transitions.get(startPosition);
		setVisited(startPosition);
		
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
				if (additions.containsKey(missed)) {
					Character addition = additions.get(missed);
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
			setVisited(ch);
			numberOfCombinations += calculateCombinations(ch, patternLength - 1);
			setUnvisited(ch);
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

	public static void main(String[] args) {
		ScreenLock sl = new ScreenLock();
		System.out.println(sl.calculateCombinations('C', 2));
		System.out.println(sl.calculateCombinations('E', 2));
		System.out.println(sl.calculateCombinations('E', 4));
	}
}