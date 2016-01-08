package oatwo;

public class TreeIsSubTree {
	/*
	 * Solution is to check whether tree2 is subtree of tree1 or not.
	 * Return boolean value, true means node2 is subtree of node1, otherwise return false.
	 * Time complexity is O(n), where n is the number of tree node in tree1.
	 * 
     * @Param {TreeNode} node1 - root node of tree1.
	 * @Param {TreeNode} node2 - root node of tree2.
	 */
	public static boolean Solution(TreeNode node1, TreeNode node2) {
		// Base case.
		if (node1 == null && node2 == null) return true;
		if (node1 == null) return false;
		if (node2 == null) return true;
		
		// Return true case.
		if (node1.val == node2.val && isSameTree(node1, node2)) {
			return true;
		}
		
		return Solution(node1.left, node2) || Solution(node1.right, node2);
	}
	
	/*
	 * isSameTree is to use recursive method to check whether tree1 and tree2 are same tree or not.
	 * Return boolean value, true means they are same tree, otherwise return false.
	 * Time complexity is O(max(tree1's node number, tree2's node number)).
	 * 
	 * @Param {TreeNode} node1 - root node of tree1.
	 * @Param {TreeNode} node2 - root node of tree2.
	 */
	public static boolean isSameTree(TreeNode node1, TreeNode node2) {
		// Base case.
		if (node1 == null && node2 == null) return true;
		if (node1 == null || node2 == null) return false;
		
		// return true case.
		if (node1.val != node2.val) return false;
		
		return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
	}
}
