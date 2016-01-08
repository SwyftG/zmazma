package oatwo;




public class TreeAmplitude {
	/*
	 * Solution is to get the amplitude of a tree.
	 * Return an integer which is the amplitude of the tree.
	 * 
	 * 
	 *  @Param {TreeNode} root - the root node of tree.
	 */
	public static int Solution(TreeNode root) {		// recursive
		
		//Handle illegal case.
		if (root == null) return 0;
		return helper(root, root.val, root.val);
	}
	
	/*
	 * Helper method is to recursive the tree and find the tree's amplitude.
	 * Return the distance of max node and min node of current path.
	 * 
	 * @Param {TreeNode} root - the root node of the tree.
	 * @Param {int} min - the minimal value of current path.
	 * @Param {int} max - the maximal value of current path. 
	 */
	public static int helper(TreeNode node, int min, int max) {
		
		// base case
		if (node == null) return max - min;
		
		//If current node.val is less than min, set min value to be node.val
		if (node.val < min) min = node.val;
		
		//If current node.val is greater than max, set max value to be node.val.
		if (node.val > max) max = node.val;
		
		//Return the maximual between node.left and node.right
		return Math.max(helper(node.left, min, max), helper(node.right, min, max));
	}
	
	
	
	
	public static int MAX;
	public static int Solution2222(TreeNode root) {		//DFS
		if (root == null) return 0;
		dfs(root, root.val, root.val);
		return MAX;
	}
	
	
	public static void dfs(TreeNode node, int min, int max) {
		if (node == null) return;
		min = Math.min(node.val, min);
		max = Math.max(node.val, max);
		if (node.left == null && node.right == null) {
			MAX = Math.max(max - min, MAX);
		}
		dfs(node.left, min, max);
		dfs(node.right, min, max);
	}
}
