package testforfun;

public class Find2DMaze {
	public static boolean Solution(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] visited = new int[m][n];
		
		boolean flag = helper(visited, matrix, 0, 0);
		
		return flag;
	}
	
	public static boolean helper(int[][] visited, int[][] matrix, int x, int y) {
		if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y] == 1 || matrix[x][y] == 1) return false;
		if (matrix[x][y] == 9) return true;
		visited[x][y] = 1;
		boolean flag = helper(visited, matrix, x + 1, y) || helper(visited, matrix, x , y + 1) || helper(visited, matrix, x - 1, y) || helper(visited, matrix, x, y - 1);
		visited[x][y] = 0;
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		int[][] a = {
			     {1,0,0,0,0},
			     {1,1,1,1,1},
			     {1,0,0,0,0},
			     {0,0,9,0,0}
			                }; 
	int[][] b = {{1,0,0,0,0},
			     {1,1,1,1,1},
			     {1,0,0,0,1},
			     {0,0,9,1,1}};  
	int[][] c = {{1,1,1,1},
			     {1,0,0,0},
			     {1,9,0,0}};
	int[][] d = {{1,1,1,1,1,1},
				 {1,1,1,1,0,0},
				 {0,0,1,0,0,0},
				 {1,1,1,1,1,1},
				 {1,0,0,0,1,0},
				 {1,1,1,0,9,0}};  
	
		int[][] m = {{0, 1, 9}, 
					 {0, 1, 0}, 
					 {0, 0, 0}};
		System.out.println(Solution(a));
		System.out.println(Solution(b));
		System.out.println(Solution(c));
		System.out.println(Solution(d));
		System.out.println(Solution(m));
	}
}
