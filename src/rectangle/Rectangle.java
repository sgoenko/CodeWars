package rectangle;

public class Rectangle {
	public int x1;
	public int y1;
	public int x2;
	public int y2;

	public int area() {
		return (x2 - x1) * (y2 - y1);
	}
	
	public int intersectArea(Rectangle r) {
		int left = Math.max(x1, r.x1);
		int top = Math.min(y2, r.y2);
		int right = Math.min(x2, r.x2);
		int bottom = Math.max(y1, r.y1);

		int width = right - left;
		int height = top - bottom;

		if (width < 0 || height < 0)
			return 0;

		return width * height;
	}

	public Rectangle(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

}
