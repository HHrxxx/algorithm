package leetcode;
/**
 * 翻转二叉树(交换左右子树)
 *
 */
public class _tree_invertTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {

		if (root == null)
			return root;

		TreeNode node = root.right;
		root.right = invertTree(root.left);
		root.left = invertTree(node);

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
