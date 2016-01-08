package testforfun;

public class RotateMatrix {
	
	//	11111111111111
	public static int[][] Solution(int[][] matrix, int flag) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return matrix;
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[][] result = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = flag == 0 ? matrix[m - j - 1][i] : matrix[j][n - i - 1];
			}
		}
		return result;
	}
	
	
	
	
	
	//	22222222222222
	public int[][] Solution2(int[][] matrix, int flag) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)	return matrix;
		//int m = matrix.length, n = matrix[0].length;
		int[][] rvalue;
		rvalue = transpose(matrix);
		flip(rvalue, flag);
		return rvalue;
	}
	
	private int[][] transpose(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[][] rvalue = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				rvalue[i][j] = matrix[j][i];
		return rvalue;
	}
	
	private void flip(int[][] matrix, int flag) {
		int m = matrix.length, n = matrix[0].length;
		if (flag == 1) {	//clock wise
			for (int i = 0; i < m; i++)
				for (int j = 0; j < n / 2; j++) {
					matrix[i][j] ^= matrix[i][n-j-1];
					matrix[i][n-j-1] ^= matrix[i][j];
					matrix[i][j] ^= matrix[i][n-j-1];
				}
		}
		else {
			for (int i = 0; i < m / 2; i++)
				for (int j = 0; j < n; j++) {
					matrix[i][j] ^= matrix[m-i-1][j];
					matrix[m-i-1][j] ^= matrix[i][j];
					matrix[i][j] ^= matrix[m-i-1][j];
				}
		}
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		int[][] a = {{1,2,3, 4},{5,6, 7, 8}};
		int[][] m = Solution(a, 1);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
