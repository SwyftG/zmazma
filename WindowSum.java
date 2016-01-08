package oatwo;

public class WindowSum {
	/*
	 * Solution is to get the sum of window in size k.
	 * Return an integer array which is the window sum of arr.
	 * Time complex is O(n), space complex is O(n)
	 * 
	 * @Param {int[]} arr - input array.
	 * @Param {int} k - window size;
	 */
	public static int[] Solution(int[] arr, int k) {
		// Initialize output array
		int[] result = new int[arr.length - k + 1];
		
		// Handle corner case.
		if (arr == null || arr.length == 0 || k == 1) return arr;
		if (k == 0) return result;
		
		int left = 0;
		int right = 0;
		int sum = 0;
		// Get the first element value of result array
		for (int i = 0; i < k; i++) {
			sum += arr[i];
			right = i;
		}
		
		result[0] = sum;
		right++;
		int index = 1;
		
		// Get the rest element value for result array.
		for (; right < arr.length; right++) {
			sum += arr[right];
			sum -= arr[left];
			left++;
			result[index++] = sum;
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] a = {1};
		System.out.println(Solution(a, 1));
		int[] b = Solution(a, 1);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " // ");
		}
	}
}
