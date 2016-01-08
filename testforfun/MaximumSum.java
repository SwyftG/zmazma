package testforfun;

import java.util.Arrays;

public class MaximumSum {
	public static int Solution(int[] nums) {
		if (nums == null || nums.length < 4) return 0;
		Arrays.sort(nums);
		swap(nums, 0, 1);
		swap(nums, 2, 3);
		swap(nums, 0, 3);
		int sum = Math.abs(nums[0] - nums[1]) + Math.abs(nums[1] - nums[2]) + Math.abs(nums[2] - nums[3]);  
		return sum;
	}
	
	private static void swap(int[] array, int i, int j) {
		array[i] ^= array[j];
		array[j] ^= array[i];
		array[i] ^= array[j];
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4};
		System.out.println(Solution(a));
	}
}
