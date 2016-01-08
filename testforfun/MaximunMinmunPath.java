package testforfun;

public class MaximunMinmunPath {
	//	1111111
	public static int Solution(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = matrix[0][0];
		for (int i = 1; i < m; i++) {
			dp[i][0] = Math.min(dp[i - 1][0], matrix[i][0]);
		}
		for (int i = 1; i < n; i++) {
			dp[0][i] = Math.min(dp[0][i - 1], matrix[0][i]);
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(Math.min(dp[i - 1][j], matrix[i][j]), Math.min(dp[i][j - 1], matrix[i][j]));
			}
		}
		return dp[m - 1][n - 1];
	} 
	
	
	
	//	22222222
	public static int Solution2(int[][] M){
		if(M.length == 0 || M[0].length == 0){
			return 0;
		}
		int[] res = {Integer.MIN_VALUE};
		DFS(M, 0, 0, Integer.MAX_VALUE, res);
		return res[0];
	}
	
	public static void DFS(int[][] M, int i, int j, int min, int[] res){
		if(i == M.length || j == M[0].length) {
			return;
		}
		if(i == M.length - 1 && j == M[0].length - 1) {
			res[0] = res[0] > min ? res[0] : min;
			return;
		}
		min = min < M[i][j] ? min : M[i][j];
		DFS(M, i+1, j, min, res);
		DFS(M, i, j+1, min, res);
	}

	
	
	public static void main(String[] args) {
		int[][] a = {{8,4,7, 8},{6,5,9, 10}, {9,8,9,9}};
		int[][] M = {
				{8,2,3,4},
				{7,4,6,2},
				{-1,5,7,2},
				{8,2,3,6},
			};

		System.out.print(Solution2(M));
	}
}
