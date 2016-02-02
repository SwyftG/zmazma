package Zati;

import java.util.HashSet;

public class twosummin {
	public static int twosum(int[] nums, int target) {
		if (nums == null || nums.length < 2) return 0;
		
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i])) continue;
			int plustarget = nums[i] + target;
			int minustarget = nums[i] - target;
			while (set.contains(plustarget)) {
				count++;
				set.remove(plustarget);
				plustarget += target;
			}
			while (set.contains(minustarget)) {
				count++;
				set.remove(minustarget);
				minustarget -= target;
			}
		}
		return count;
	}
	
	
	public static int[] stairs(int n) {
		int[] result = new int[n];
		int cur = 1;
		int pre = 1;
		result[0] = 1;
		result[1] = 1;
		for (int i = 2; i < n; i++) {
			int tmp = cur;
			cur += pre;
			pre = tmp;
			result[i] = cur;  
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] a = {7,11,144,1,2,5,4};
		System.out.println(twosum(a, 1));
		
		int[] mm = stairs(5);
		for (int i = 0; i < mm.length; i++) {
			System.out.println(mm[i]);
		}
	}
}
