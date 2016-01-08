package oatwo;

import java.util.PriorityQueue;

import oatwo.Point;

import java.util.Comparator;

public class KPointFind {
	/*
	 * Solution is to fund the k most nearly point to original point.
	 * Return the K points.
	 * Use PriorityQueue to implement a min heap to get k nearly points.
	 * Time complexity is O(n), Space Complex is O(k).
	 * 
	 * @Param {Point} points - total points in plane
	 * @Param {int} k
	 */
	public static Point[] Solution(Point[] points, Point original, int k) {
		Point[] result = new Point[k];
		// Handle corner case
		if (points == null || points.length == 0 || k == 0) return result;
		
		// Use a priority queue to implement a minheap with maximaul size of k
		PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>(){
			@Override
			public int compare(Point p1, Point p2) {
				return getDistanceBetweenTwoPoints(p2, original) - getDistanceBetweenTwoPoints(p1, original);
			} 
		});
		
		// Offer each points into priority queue.
		for (int i = 0; i < points.length; i++) {
			queue.offer(points[i]);
			// If i >= k, queue should poll elements to maintain the length k.
			if (i >= k) {
				queue.poll();
			}
		}
		
		// Get k points out of queue.
		int index = k;
		while (!queue.isEmpty()) {
			result[--k] = queue.poll();
		}
		
		return result;
	}
	
	
	
	
	public static int getDistanceBetweenTwoPoints(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}
	
	
	
	
	
	public static void main(String[] args) {
		Point[] points = {new Point(0,0),new Point(0,1),new Point(0,2),new Point(0,3),new Point(0,4),new Point(0,5),new Point(3,0)};
		Point[] poi = {};
		Point ori = new Point(0,0);
		Point[] result = Solution(points, ori, 3);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i].x + " //" + result[i].y);
		}
	}
}
