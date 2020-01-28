package leetcode;

public class _tree_isBalanced {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public static boolean balance = true;
	
	public static boolean isBalanced(TreeNode root) {
		getDepth(root);
		return balance;
	}
	
	public static int getDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = getDepth(root.left);
		int right = getDepth(root.right);

		if (Math.abs(left - right) > 1) {
			balance = false;
		}
		return Math.max(left + 1, right + 1);

	}

	public static void main(String[] args) {
		TreeNode n1=new TreeNode(3);
		TreeNode n2=new TreeNode(9);
		TreeNode n3=new TreeNode(20);
		TreeNode n4=new TreeNode(15);
		TreeNode n5=new TreeNode(7);
		
		n1.left=n2;
		n1.right=n3;
		n3.left=n4;
		n3.right=n5;
		isBalanced(n1);

	}

}
