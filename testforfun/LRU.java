package testforfun;


import java.util.LinkedList;
import java.util.List;

public class LRU {
	public static int Solution(int[] array, int size) {
		if (array == null || array.length == 0) return 0;
		List<Integer> cache = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (cache.contains(array[i])) {
				cache.remove(new Integer(array[i]));
			} else {
				count++;
				if (cache.size() == size) {
					cache.remove(0);
				}
			}
			cache.add(array[i]);
			//System.out.println(cache);
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,4,1};
		System.out.println(Solution(a, 4));
	}
}
