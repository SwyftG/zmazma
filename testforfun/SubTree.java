package testforfun;

public class SubTree {
	public static boolean isSubTree(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) return true;
		if (node1 == null) return false;
		if (node2 == null) return true;
		if (node1.val == node2.val && isSameTree(node1, node2)) {
			return true;
		}
		return isSubTree(node1.left, node2) || isSubTree(node1.right, node2);
	}
	
	public static boolean isSameTree(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) return true;
		if (node1 == null || node2 == null) return false;
		if (node1.val != node2.val) return false;
		return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
	}
	
	public static void main(String[] arg) {
		TreeNode node1 = new TreeNode(1);
		node1.left = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		System.out.println(isSubTree(node1, node2));
	}
}
