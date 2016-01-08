package testforfun;

import java.util.LinkedList;
import java.util.Queue;

public class MinPathSum {
	public static int Solution(TreeNode root) {
//		if (root == null) return 0;							recursive
//		if (root.left != null && root.right == null) {
//			return root.val + Solution(root.left);
//		}
//		if (root.left == null && root.right != null) {
//			return root.val + Solution(root.right);
//		}
//		return root.val + Math.min(Solution(root.left), Solution(root.right));
		
		
		
		if (root == null) return 0;
		Queue<TreeNode> nodequeue = new LinkedList<TreeNode>();
		Queue<Integer> sumqueue = new LinkedList<Integer>();
		nodequeue.add(root);
		sumqueue.add(0);
		int result = Integer.MAX_VALUE;
		while (!nodequeue.isEmpty()) {
			int size = nodequeue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = nodequeue.poll();
				int sum = sumqueue.poll();
				if (node.left != null) {
					nodequeue.add(node.left);
					sumqueue.add(node.val + sum);
				}
				if (node.right != null) {
					nodequeue.add(node.right);
					sumqueue.add(node.val + sum);
				}
				if (node.left == null && node.right == null) {
					result = Math.min(result, sum + node.val);
				}
			}
		}
		return result;
		
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(7);
	//	root.left.left = new TreeNode(4);
	//	root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println(Solution(root));
	}
}
