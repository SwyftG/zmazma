package testforfun;

import java.util.ArrayList;
import java.util.List;

public class AmplitudeOfTree {
	public static int Solution(TreeNode root){
		if (root == null) return 0;
		return helper(root, root.val, root.val);
	}
	public static int helper(TreeNode root, int min, int max) {
		if (root == null) return max - min;
		if (root.val < min) min = root.val;
		if (root.val > max) max = root.val;
		return Math.max(helper(root.left, min, max), helper(root.right, min, max));
	}
	
	
	
	
	//222222
	public static int Solution2(TreeNode root) {
		if (root == null) return 0;
		int max = 0;
		List<Integer> maxs = new ArrayList<Integer>();
		List<Integer> maxmin = new ArrayList<Integer>();
		maxmin.add(root.val);
		maxmin.add(root.val);
		dfs(root, maxmin, maxs);
		for (int i = 0; i < maxs.size(); i++) {
			max = Math.max(max, maxs.get(i));
			System.out.println(maxs.get(i));
		}
		return max;
	} 
	
	public static void dfs(TreeNode root, List<Integer> maxmin, List<Integer> maxs) {
		if (root.left == null && root.right == null) maxs.add(maxmin.get(1) - maxmin.get(0));
		if (root.left != null) {
			List<Integer> tmp = new ArrayList<>(maxmin);
			if (root.left.val < maxmin.get(0)) tmp.set(0, root.left.val);
			if (root.left.val > maxmin.get(1)) tmp.set(1, root.left.val);
			dfs(root.left, tmp, maxs);
		}
		if (root.right != null) {
			List<Integer> tmp = new ArrayList<>(maxmin);
			if (root.right.val < maxmin.get(0)) tmp.set(0, root.right.val);
			if (root.right.val > maxmin.get(1)) tmp.set(1, root.right.val);
			dfs(root.right, tmp, maxs);
		}
		return;
	}
	
	
	//3333333
	public static int MAX;
	public static int getAmplitude(TreeNode root){
	if(root==null) return 0;
	dfs(root,root.val,root.val);
	return MAX;
	}
	
	public static void dfs(TreeNode root,int min,int max){
		if(root==null) return;
		min=Math.min(min,root.val);
		max=Math.max(max,root.val);
		if(root.left==null && root.right==null){
			MAX=Math.max(MAX,max-min);
		}
		dfs(root.left,min,max);
		dfs(root.right,min,max);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(8);
		root.right = new TreeNode(9);
		root.left.left = new TreeNode(12);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(4);
		root.right.left.left = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		System.out.println(getAmplitude(root));
	}
	
}
