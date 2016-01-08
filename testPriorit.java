package oatwo;

import java.util.*;

public class testPriorit {
	public static void sss(int[] arr) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;		// decreasing
			}

		
			
		});
		for (int i = 0; i < arr.length; i++) {
			q.add(arr[i]);
			if (i >= 3) q.poll();
		}
		while (!q.isEmpty()) {
			int m = q.poll();
			System.out.print(m + " * ");
		}
	}
	
	
	public static void main(String[] args) {
		int[] a = {6,5,3,4,2,1};
		sss(a);
	}
}
