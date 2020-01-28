package leetcode;

/**
 *  找到该树中两个指定节点的最近公共祖先
 *
 */

public class _tree_lowestCommonAncestor {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return root;
		}
		if (root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		} else if (left != null) {
			return left;
		} else if (right != null) {
			return right;
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(6);
		TreeNode n5 = new TreeNode(2);
		n1.left = n2;
		n1.right = n3;
//		n2.left=n4;
//		n3.right=n5;
		System.out.println(lowestCommonAncestor(n1, n2, n3).val);
	}
}
