package oatwo;

public class RotateMatrix {
	/*
	 * Solution is to rotate a matrix in clockwise or anticlockwise.
	 * Return the rotated matrix.
	 * Time complexity is O(m * n), where m is length and n is width of matrix.
	 * Space complexity is O(m * n) 
	 * 
	 * @Param {int[][]} matrix
	 * @Param {int} flag
	 */
	public static int[][] Solution(int[][] matrix, int flag) {
		
		// Handle illegal input.
		if (matrix == null || matrix.length == 0 || matrix[0] == null ||  matrix[0].length == 0) return matrix;
		
		// Get length and width of matrix and initialize result matrix.
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] result = new int[n][m];
		
		// Rotate matrix. 0 means clockwise, 1 means anticlockwise.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = flag == 0 ? matrix[m - j - 1][i] : matrix[j][n - i - 1];
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[][] a = {{1},{5,6}};
		int[][] m = Solution(a, 0);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
}
