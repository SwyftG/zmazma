package oatwo;

public class GCD {
	/*
	 * Solution is to get the greatest common divisor of nums array.
	 * Return greatest common divisor.
	 * First get the two gcd of first two element in array, then continual go through array,
	 * and get new gcd from gcd and other rest element.
	 * Time complexity is O(n), space complexity is O(1).
	 *
	 * 
	 * @Param {int[]} nums - input array
	 */
	public static int Solution(int[] nums) {
		
		// Handle corner case.
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		
		int gcd = nums[0];
		for (int i = 1; i < nums.length; i++) {
			
			// One corner case.
			if (nums[i] == 0) return 0;
			int dividend = nums[i];
			
			// Get greatest common divisor form gcd and nums[i].
			while (dividend % gcd != 0) {
				int tmp = dividend % gcd;
				dividend = gcd;
				gcd = tmp;
			}
		}
		return gcd;
	}
	
	public static void main(String[] args) {
		int[] a = {48, 24, 8, 12};
		System.out.println(Solution(a));
	}
}
