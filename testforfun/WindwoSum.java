package testforfun;

import java.util.ArrayList;
import java.util.List;

public class WindwoSum {
	public static List<Integer> getWindowSum(int[] arr, int size) {
		List<Integer> result = new ArrayList<Integer>();
		if (arr == null || arr.length == 0 || size == 0) return result;
		int left = 0;
		int right = 0;
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += arr[i];
			right = i;
		}
		result.add(sum);
		right++;
		for (; right < arr.length; right++) {
			sum += arr[right];
			sum -= arr[left];
			left++;
			result.add(sum);
		}
		
		return result;
	}
	
	public static int[] getWindowSum2(int[] arr, int size) {
		int[] result = new int[arr.length - size + 1];
		if (arr == null || arr.length == 0 || size == 0) return result;
		int left = 0;
		int right = 0;
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += arr[i];
			right = i;
		}
		result[0] = sum;
		int index = 1;
		right++;
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
		System.out.println(getWindowSum(a, 1));
		int[] b = getWindowSum2(a, 0);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " // ");
		}
	}
}
