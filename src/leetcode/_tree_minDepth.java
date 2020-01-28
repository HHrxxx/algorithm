package leetcode;
/**
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量
 * 输入为 [1,2]，最小深度不是1，而是2
 * 注意题目说的是叶子点，即左右子树均为空。
 *
 */
public class _tree_minDepth {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int min = Integer.MAX_VALUE;

	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		depth(root, 1);
		return min;
	}

	public static void depth(TreeNode root, int h) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			min = Math.min(min, h);
			return;
		} else {
			if (root.left != null)
				depth(root.left, h + 1);
			if (root.right != null)
				depth(root.right, h + 1);
		}

	}

	public static void main(String[] args) {

		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);

		n1.left = n2;
//		n1.right = n3;
//		n3.left = n4;
//		n3.right = n5;
		minDepth(n1);
	}

}
