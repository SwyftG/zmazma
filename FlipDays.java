package oatwo;

public class FlipDays {
	/*
	 * Solution is to get nums array after k days.
	 * Return nums array in k days.
	 * Use a temp array to recored after flip every day, flip k times.
	 * Time complexity is O(n*k), space complex is O(n).
	 * 
	 * @Param {int[]} nums - input array
	 * @Param {int} k - the number of days
	 */
	public static int[] Solution(int[] nums, int k) {
		
		// Handle illegal input and corner case
		if (nums == null || nums.length == 0 || k == 0) return nums;
		
		// Initialized result array and temp array.
		int[] result = new int[nums.length];
		int[] temp = new int[nums.length + 2];
		temp[0] = 0;
		temp[temp.length - 1] = 0;
		for (int i = 0; i < nums.length; i++) {
			temp[i + 1] = nums[i];
		}
		
		int day = 0;
		while (day < k) {
			int[] arr = new int[nums.length + 2];
			arr[0] = temp[0];
			arr[arr.length - 1] = 0;
			// flip array and set result into new array.
			for (int i = 1; i < arr.length - 1; i++) {
				arr[i] = temp[i - 1] == temp[i + 1] ? 0 : 1;
			}
			// Set after flip array to be temp array
			temp = arr;
			day++;
		}
		for (int i = 1; i < temp.length - 1; i++) {
			result[i - 1] = temp[i];
		}
		return result;
	}
	
	
	
	
	public static void main(String[] args) {
		int[] a = {0,1,1,1};
		a = Solution(a, 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
