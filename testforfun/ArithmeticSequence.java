package testforfun;



public class ArithmeticSequence {
	//1111111
	public static int countSequence(int[] nums) {
		if (nums == null || nums.length < 3) return 0;
		int[] dis = new int[nums.length - 1];
		for (int i = 0; i < nums.length - 1; i++) {
			dis[i] = nums[i] - nums[i + 1];
		}
		int count = 0;
		
		for (int i = 0; i < dis.length; i++) {
			int smallcount = 1;
			while (i + 1 < dis.length && dis[i] == dis[i + 1]) {
				smallcount++;
				i++;
			}
			count = count + getNum(smallcount);
		}
		
		return count > 1000000000 ? -1 : count;
	}
	
	public static int getNum(int x) {
		return x * (x - 1) / 2;
	}
	
	//	222222
	public static int find(int[] nums) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		int left = 0;
		int right = 1;
		int diff = nums[1] - nums[0];
		int cnt = 0;
		while (right < nums.length - 1) {
			if (diff != nums[right + 1] - nums[right]) {
				cnt += (right - left - 1) * (right - left) / 2;
				if (cnt > 1000000000) {
					return -1;
				}
				diff = nums[right + 1] - nums[right];
				left = right;
			}
			right++;
		}
		cnt += (right - left - 1) * (right - left) / 2;
		return cnt > 1000000000 ? -1 : cnt;
	}
	
	public static void main(String[] args) {
		int[] num = {-1, 1, 3, 3, 3, 2, 1, 0 };
		int[] arr = {2,5,2,3,4,6,8,10,12,9,8,7,6,2,4,8};
		System.out.println(countSequence(arr));
	}
}
