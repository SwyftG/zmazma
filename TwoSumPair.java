package oatwo;

import java.util.HashMap;

public class TwoSumPair {
	/*
	 * Solution is to count number of pairs in array and two element's sum equal target
	 * Return number of pairs.
	 * Use a HashMap to recored array element and its count number.
	 * Time complexity is O(n), space complexity is O(n).
	 * 
	 * @Param {int[]} nums - input integer array.
	 * @Param {int} target - target.
	 */
	public static int Solution(int[] nums, int target) {
		// Base case.
		if (nums == null || nums.length < 2) return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		// Iterator through array can get the count of pairs.
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				count += map.get(target - nums[i]);
			}
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		return count;
	}
}
