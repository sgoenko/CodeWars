package RangeExtraction;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static String rangeExtraction (int[] arr) {
		List<String> ls = new ArrayList<>();
		int consecutiveCounter = 0;
		for (int i = 0; i < arr.length; ) {
			consecutiveCounter = 0;
			String start = String.valueOf(arr[i]);
			while (i != arr.length - 1 && arr[i + 1] - arr[i] == 1) {
				consecutiveCounter++;
				i++;
			}
			if (consecutiveCounter > 0) {
				if (consecutiveCounter > 1) start += "-" + (Integer.parseInt(start) + consecutiveCounter);
				else i--;
			}
			ls.add(start);
			i++;
		}

		return String.join(",", ls);
	}
}