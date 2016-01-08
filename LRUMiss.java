package oatwo;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUMiss {
	/*
	 * Solution method is to count the number of miss in LRU
	 * Return the number of missing.
	 * 
	 * Time complexity(n), space complexity(length of size)
	 * 
	 * @Param {int[]} nums - the input job array of LRU
	 * @Param {int} size - the maximual size of cache in LRU
	 */
	public static int Solution(int[] nums, int size) {
		
		// Handle corner case
		if (nums == null || nums.length == 0 || size == 0) return 0;
		
		int count = 0;
		
		// Use a List to be a cache in LRU
		List<Integer> cache = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (cache.contains(nums[i])) {
				// If cache already has the task, we remove the old one.
				cache.remove(new Integer(nums[i]));
			} else {
				count++;
				if (cache.size() == size) {
					// If cache has be full and a new task want to be called,
					// we remove the latest recently used task.
					cache.remove(0);
				}
			}
			cache.add(nums[i]);
		}
		return count;
	}
	
	
	
	// Declare a LRUHashMap class to be a LRU cache.
	static class LRUHashMap extends LinkedHashMap<Integer, Integer> {
		private int capacity;
		
		// LRUHashMap constructor.
		public LRUHashMap(int capacity) {
			super(capacity, 0.75f,true);
			this.capacity = capacity;
		}
		
		@Override
		protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
		   return size() > this.capacity;
		}
	}
	/*
	 * Solution method is to count the number of miss in LRU
	 * Return the number of missing.
	 * Use LinkedHashMap data structure to implement a LRU cache.
	 * 
	 * Time complexity is O(n), space complexity is O(length of size)
	 * 
	 * @Param {int[]} nums - the input job array of LRU
	 * @Param {int} size - the maximual size of cache in LRU
	 */
	public static int Solution2(int[] nums, int size) {
		
		// Corner case.
		if (nums == null || nums.length == 0 || size == 0) return 0;
		int count = 0;
		
		LRUHashMap map = new LRUHashMap(size);
		for (int i = 0; i < nums.length; i++) {
			// If LRU cache does not contains task, missing number add one, and add current task into cache.
			// If cache is full and there is another task need to add into cache, the cache will remove the latest recently used task.
			if (!map.containsKey(nums[i])) {
				count++;
				map.put(nums[i], nums[i]);
			} else {
				// If cache has task, LRUHashMap should call it.
				map.get(nums[i]);
			}
			System.out.println(map);
		}
		return count;
	}
	
	
	
	
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,4,1};
		int[] b = {5,4,3,2,1,2,5};
		System.out.println(Solution2(b, 4));
	}
}
