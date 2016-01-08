package oatwo;

import java.util.Arrays;

public class FourIntegers {
	/*
	 * Solution is to find the abs(S[0] - S[1]) + XXXXXX to be the largest one.
	 * Return the largest value of F(s).
	 * First sorted the array, then swap the position. Get the value.
	 * Time complex is O(1), space complex is O(1).
	 * 
	 * @Param {int} a 
	 * @Param {int} b
	 * @Param {int} c
	 * @Param {int} d 
	 */
	public static int Solution(int a, int b, int c, int d) {
		
		// Initialize an integer array, size of 4.
		int[] tmp = new int[4];
		tmp[0] = a;
		tmp[1] = b;
		tmp[2] = c;
		tmp[3] = d;
		
		// Sort array in ascending order.
		Arrays.sort(tmp);
		
		// Swap the position.
		swap(tmp, 0, 1);
		swap(tmp, 2, 3);
		swap(tmp, 0, 3);
		
		// Get the maximal value of F(s)
		int sum = Math.abs(tmp[0] - tmp[1]) + Math.abs(tmp[1] - tmp[2]) + Math.abs(tmp[2] - tmp[3]);
		return sum;
	}
	/*
	 * swap function is two swap the value of array[a] and array[b].
	 */
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	
}
