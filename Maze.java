package oatwo;


/*
 * Write code,  6 min.
 * Comment 10min.
 */

public class Maze {
	/*
	 * Solution is to find whether there is a path to 9 in matrix.
	 * Return 1 means it has, 0 means no.
	 * Used dfs method to find whether there is a path to direction.
	 * Time complexity is O(n * m), where n is the length of matrix, m is width of matrix.
	 * 
	 * 
	 * @Param {int[][]} matrix - input two dimension array.
	 */
	public static int Solution(int[][] matrix) {
		
		// Handle illegal case
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		
		// Get length and width of matrix
		int m = matrix.length;
		int n = matrix[0].length;
		
		// Visited two dimension array is to recored whether the point in matrix has explored or not.0
		int[][] visited = new int[m][n];
		
		// DFS to find whether the path has existed.
		boolean canFind = helper(visited, matrix, 0, 0);
		
		// If canFind is true, return 1, otherwise return 0.
		return canFind == true ? 1 : 0;
	}
	
	/*
	 * Helper function is DFS searching two dimension array
	 * Return boolean value 
	 * 
	 * 
	 * @Param {int[][]} visited - two dimension array to recored visited situation
	 * @Param {int[][]} matrix - input two dimension array
	 * @Param {int} x
	 * @Param {int} y
	 */
	public static boolean helper(int[][] visited, int[][] matrix, int x, int y) {
		
		//Base case
		if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y] == 1 || matrix[x][y] == 1) return false;
		
		//If (x,y) value is 9, means we find it. Return true.
		if (matrix[x][y] == 9) return true;
		
		//Set current point's visited state be 1, means has visited. 0 means not visit yet.
		visited[x][y] = 1;
		
		//Explore next point after current point.
		boolean flag = helper(visited, matrix, x + 1, y) || 
					   helper(visited, matrix, x - 1, y) ||
					   helper(visited, matrix, x, y + 1) ||
					   helper(visited, matrix, x, y - 1);
		
		//Set current point's visited state be 0.
		visited[x][y] = 0;
		
		return flag;
	}
	
	
	
	
	public static void main(String[] args) {
		int[][] a = {
			     {0,1,1,1,1},
			     {0,0,0,0,0},
			     {0,1,1,1,1},
			     {1,1,9,1,1}
			                }; 
	int[][] b = {{0,1,1,1,1},
			     {0,0,0,0,0},
			     {0,1,1,1,0},
			     {1,1,9,0,0}};  
	int[][] c = {{0,0,0,0},
			     {0,1,1,1},
			     {0,9,1,1}};
	int[][] d = {{0,0,0,0,0,0},
				 {0,0,0,0,1,1},
				 {1,1,0,1,1,1},
				 {0,0,0,0,0,0},
				 {0,1,1,1,0,1},
				 {0,0,0,1,9,1}};  
	
		int[][] m = {{1, 0, 0}, 
					 {0, 0, 0}, 
					 {0, 0, 0}};
		System.out.println(Solution(a));
		System.out.println(Solution(b));
		System.out.println(Solution(c));
		System.out.println(Solution(d));
		System.out.println(Solution(m));
	}
}
