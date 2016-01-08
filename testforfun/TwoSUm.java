package testforfun;

import java.util.HashMap;

public class TwoSUm {
	public static int twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
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
	
	public static void main(String[] args) {
		int rvalue = twoSum(new int[] {8,7,5,2,3,4,6,9}, 6);
		System.out.println(rvalue);
		return;
	}
}
