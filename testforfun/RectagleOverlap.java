package testforfun;


class Point2{
	int x;
	int y;
	public Point2(int a, int b) {
		x = a;
		y = b;
	}
}

public class RectagleOverlap {
	public static boolean Solution(Point2 l1, Point2 r1, Point2 l2, Point2 r2) {
		if (l1.x > r2.x || l2.x > r1.x) 
			return false;	// dont over lap
		if (l1.y < r2.y || l2.y < r1.y)
			return false;
		return true;
	}
	
	
	public static void main(String[] args) {
		Point2 a1 = new Point2(0, 1);
		Point2 b1 = new Point2(1, 0);
		Point2 a2 = new Point2(0, 15);
		Point2 b2 = new Point2(10,0);
		System.out.println(Solution(a1,b1,a2,b2));
	}
}
