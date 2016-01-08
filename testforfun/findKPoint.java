package testforfun;

import java.util.Comparator;
import java.util.PriorityQueue;

public class findKPoint {
	public static Point[] kPoint(Point[] points, Point origin, int k) {
		Point[] result = new Point[k];
		if (points == null || points.length == 0) return result;
		PriorityQueue<Point> queen = new PriorityQueue<Point>(k, new Comparator<Point>(){
			public int compare(Point p1, Point p2) {
				return getDistance(p2, origin) - getDistance(p1, origin);
			}
		});
		for (int i = 0; i < points.length; i++) {
			queen.offer(points[i]);
			if (i >= k) queen.poll();
		}
		int index = k;
		while (!queen.isEmpty()) {
			result[--k] = queen.poll();
		}
		return result;
	}
	public static int getDistance(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}
	
	
	
	public static void main(String[] args) {
		Point[] points = {new Point(0,0),new Point(0,1),new Point(0,2),new Point(0,3),new Point(0,4),new Point(0,5),new Point(3,0)};
		Point ori = new Point(0,0);
		Point[] result = kPoint(points, ori, 6);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i].x + " //" + result[i].y);
		}
	}
}
