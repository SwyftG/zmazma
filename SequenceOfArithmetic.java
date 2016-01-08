package oatwo;

public class SequenceOfArithmetic {
	/*
	 * Solution is to get number of arithmetic sequence in an array
	 * Return number of arithmetic sequence.
	 * Get the difference between adjacent of input array, then 
	 * go through the difference, count the number of arithmetic sequence.
	 * Time complexity is O(n), space complexity is O(n).
	 * 
	 * @Param {int[]} nums - input array.
	 */
	public static int Solution(int[] nums) {
		
		// Handle illegal input.
		if (nums == null || nums.length < 3) return 0;
		
		// Get difference of adjacent element in nums array.
		int[] difference = new int[nums.length - 1];
		for (int i = 0; i < nums.length - 1; i++) {
			difference[i] = nums[i] - nums[i + 1];
		}
		
		// Get the number of arithmetic sequence.
		int count = 0;
		for (int i = 0; i < difference.length; i++) {
			int same = 1;
			while (i + 1 < difference.length && difference[i] == difference[i + 1]) {
				same++;
				i++;
			}
			// getNumber is to get arithmetic sequence number in same difference
			count = count + getNumber(same);
		}
		return count > 10000000 ? -1 : count;
	}
	
	
	/*
	 * getNumber is to get the number of arithmetic sequence in same difference.
	 * 
	 * @Param {int} x 
	 */
	public static int getNumber(int x) {
		return x * (x - 1) / 2;
	}
	
	public static void main(String[] args) {
		int[] num = {-1, 1, 3, 3, 3, 2, 1, 0 };
		int[] arr = {2,5,2,3,4,6,8,10,12,9,8,7,6,2,4,8};
		System.out.println(Solution(arr));
	}
}
