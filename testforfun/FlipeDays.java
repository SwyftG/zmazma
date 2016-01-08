package testforfun;

public class FlipeDays {
	public static int[] Solution(int[] nums, int days) {
		if (nums == null || nums.length == 0 || days == 0) return nums;
		int[] result = new int[nums.length];
		int[] arr = new int[nums.length + 2];
		arr[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			arr[i + 1] = nums[i];
		}
		arr[arr.length - 1] = 0;
		int k = 0;
		while (k < days) {
			int[] tmp = new int[nums.length + 2];
			tmp[0] = 0;
			tmp[tmp.length - 1] = 0;
			for (int i = 1; i < tmp.length - 1; i++) {
				tmp[i] = arr[i - 1] == arr[i + 1] ? 0 : 1;
			}
			arr = tmp;
			k++;
		}
 		
		for (int i = 1; i < arr.length - 1; i++) {
			result[i - 1] = arr[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {0,1,1,1};
		a = Solution(a, 2);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
