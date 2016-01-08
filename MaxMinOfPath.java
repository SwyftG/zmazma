package oatwo;

public class MaxMinOfPath {
	/*
	 * Solution is to find the maximal of min value of paths.
	 * Return the max minimum value.
	 * Use a two-dimension array to record the max min value from start point to current point.
	 * get value by using function XXXXX
	 * Time complexity is O(m * n), where m is length of martrix, n is width of matrix. Space complexity is O(m * n).
	 * 
	 * 
	 * @Param {int[][]} matrix - input two dimension array.
	 */
	public static int Solution(int[][] matrix) {
		
		// Handle illegal case.
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		
		// Initialize dp[][].
		dp[0][0] = matrix[0][0];
		for (int i = 1; i < m; i++) {
			dp[i][0] = Math.min(dp[i - 1][0], matrix[i][0]);
		}
		for (int i = 1; i < n; i++) {
			dp[0][i] = Math.min(dp[0][i - 1], matrix[0][i]);
		}
		
		// Iterate through matrix and get dp[i][j] value from dp[i - 1][j], dp[i][j - 1] and matrix.
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(Math.min(dp[i - 1][j], matrix[i][j]), Math.min(dp[i][j - 1], matrix[i][j]));
			}
		}
		
		return dp[m - 1][n - 1];
	}
	
	public static void main(String[] args) {
		int[][] a = {{8,4,7, 8},{6,5,9, 10}, {9,8,9,9}};
		int[][] M = {
				{8,2,3,4},
				{7,4,6,2},
				{-1,5,7,2},
				{8,2,3,6},
			};

		System.out.print(Solution(M));
	}
}
