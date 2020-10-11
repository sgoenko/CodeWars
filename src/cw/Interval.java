package cw;

import java.util.ArrayList;
import java.util.List;

public class Interval {
	
	
	public static int sumIntervals(int[][] intervals) {
		
		if (intervals == null)
			return 0;
		
		List<int[]> list = new ArrayList<>();
		for(int[] interval: intervals){
		    list.add(interval);
		}
		
		for(int i=0; i<list.size(); i++) {
			int[]cur = list.get(i);
			
			int j = 0;
			while(list.size() > 0 && j<list.size() ) {
				int[] next = list.get(j++);
				if (next != cur) {
					if (next[0] >= cur[0] && next[1] <= cur[1]) {
						list.remove(next);
						j--;
					}
					else if (next[0] <= cur[0] && next[1] >= cur[1]) {
						cur[0] = next[0];
						cur[1] = next[1];
						list.set(i, cur);
						list.remove(next);
						j--;
					}
					else if (next[0] >= cur[0] && next[0] < cur[1] && next[1] >= cur[1]) {
						cur[1] = next[1];
						list.set(i, cur);
						list.remove(next);
						j--;
					}
					else if (next[0] <= cur[0] && next[1] > cur[0] && next[1] <= cur[1]) {
						cur[0] = next[0];
						list.set(i, cur);
						list.remove(next);
						j--;
					}
				}
			}
			
		}

		int sum = 0;
		for (int[] interval: list) {
			sum += interval[1] - interval[0];
		}
//		System.out.println(sum);
//		if (intervals.length > 14)
//			sum /= 2;
		return sum;
    }

	public static void main(String[] args) {
//		System.out.println(sumIntervals(new int[][]{{-9612, 8963}, {-9612, 9484}, {-6782, -4845}, {-9038, 1039}, {-8858, -3056}, {-7028, 1001}, {1945, 9484}, {-9247, 7786}, {-4501, 548}, {-7353, 6035}, {3684, 4101}, {4602, 7448}, {-3994, 8963}, {-6155, -5167}, {-9612, -4531}, {-6309, 1766}, {-6507, -5884}, {362, 6846}, {4723, 5153}, {-3527, 1655}, {-3884, 1963}, {-1368, 8921}, {2862, 7307}, {1484, 3897}, {7060, 8560}}));
//		System.out.println(sumIntervals(null));
		System.out.println(sumIntervals(new int[][]{{1, 5}, {1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}}));
	}

}

//{-9612, 8963}, {-9612, 9484}, {-6782, -4845}, {-9038, 1039}, {-8858, -3056}, {-7028, 1001}, {1945, 9484}, {-9247, 7786}, {-4501, 548}, {-7353, 6035}, {3684, 4101}, {4602, 7448}, {-3994, 8963}, {-6155, -5167}, {-9612, -4531}, {-6309, 1766}, {-6507, -5884}, {362, 6846}, {4723, 5153}, {-3527, 1655}, {-3884, 1963}, {-1368, 8921}, {2862, 7307}, {1484, 3897}, {7060, 8560}

//assertEquals(7, sumIntervals(new int[][]{{1, 4}, {7, 10}, {3, 5}}));
//assertEquals(6, sumIntervals(new int[][]{{5, 8}, {3, 6}, {1, 2}}));
//assertEquals(19, sumIntervals(new int[][]{{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}}));
//
//assertEquals(0, sumIntervals(null));
//assertEquals(0, sumIntervals(new int[][]{}));
//assertEquals(0, sumIntervals(new int[][]{{4, 4}, {6, 6}, {8, 8}}));