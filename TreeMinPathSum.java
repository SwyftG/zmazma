package oatwo;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMinPathSum {
	public static int Solution(TreeNode root) {
		if (root == null) return 0;
		if (root.left != null && root.right == null) {
			return root.val + Solution(root.left);
		}
		if (root.left == null && root.right != null) {
			return root.val + Solution(root.right);
		}
		return root.val + Math.min(Solution(root.left), Solution(root.right));
	}
	
	
	
	
	
	/*
	 * Solution is to get the minimum path sum of a tree.
	 * Return the minimum path value.
	 * Use two queue to track tree level order traversal and current path sum.
	 * Time complexity is O(n), space complexity is O(n).
	 * 
	 * @Param {TreeNode} root - root node of tree
	 */
	public static int Solution2(TreeNode root) {		
		
		// Handle base case.
		if (root == null) return 0;
		
		// Initialize two queue and result to be Integer.MAX_VALUE.
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		Queue<Integer> sumQueue = new LinkedList<Integer>();
		nodeQueue.add(root);
		sumQueue.add(0);
		int result = Integer.MAX_VALUE;
		
		//Traversal tree by level order and calculate the path sum.
		while (!nodeQueue.isEmpty()) {
			int size = nodeQueue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = nodeQueue.poll();
				int sum = sumQueue.poll();
				if (node.left != null) {
					nodeQueue.add(node.left);
					sumQueue.add(node.val + sum);
				}
				if (node.right != null) {
					nodeQueue.add(node.right);
					sumQueue.add(node.val + sum);
				}
				if (node.left == null && node.right == null) {
					result = Math.min(result, sum + node.val);
				}
			}
		}
		return result;
	}
}
