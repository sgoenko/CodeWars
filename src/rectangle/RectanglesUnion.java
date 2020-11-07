package rectangle;

import java.util.ArrayList;
import java.util.List;

public class RectanglesUnion {
	public static int calculateSpace(int[][] rectangles) {
		List<Rectangle> rects = new ArrayList<>();
		for (int[] rect : rectangles) {
			rects.add(new Rectangle(rect[0], rect[1], rect[2], rect[3]));
		}
		int area = rects.stream().map(m -> m.area()).reduce((a, b) -> a + b).orElse(0);
		
		int intersectArea = 0;
		for (int i = 1; i<rects.size(); i++) {
			intersectArea += rects.get(0).intersectArea(rects.get(i));
		}

		return area - intersectArea;
	}
	
	public static void main(String[] args) {
		int[][] recs = { { 3, 3, 8, 5 }, { 6, 3, 8, 9 } };
		System.out.println(RectanglesUnion.calculateSpace(recs));

	}
}

//There are three rectangles: R1 = [3,3,8,5], R2 = [6,3,8,9], R3 = [11,6,14,12]
//S(R1) = 10, S(R2)= 12, S(R3) =  18
//S(R1 ∩ R2) = 4, S(R1 ∩ R3) = 0,  S(R2 ∩ R3) = 0
//S = S(R1) + S(R2) + S(R3) - S(R1 ∩ R2) - S(R1 ∩ R3) - S(R2 ∩ R3) = 36

