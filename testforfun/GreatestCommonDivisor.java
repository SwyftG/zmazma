package testforfun;

public class GreatestCommonDivisor {
	public static int Solution(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int gcd = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == 0) return 0;
			int divisor = nums[i];
			while (divisor % gcd != 0) {
				int tmp = divisor % gcd;
				divisor = gcd;
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
