package offer;

import offer._tree_TreeDepth.TreeNode;

/**
 * 判断该二叉树是否是平衡二叉树
 * 
 * 左右子树 深度差 <=1
 *
 */
public class _tree_IsBalanced_Solution {

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
	//？？？？？
	static boolean ans = true;

	public static boolean IsBalanced_Solution(TreeNode root) {
		TreeDepth(root);
		return ans;
	}

	public static int TreeDepth(TreeNode root) {
		if (root == null)
			return 0;
		int leftDep = TreeDepth(root.left);
		int rightDep = TreeDepth(root.right);
		if (Math.abs(leftDep - rightDep) > 1) {
			ans = false;
		}
		return Math.max(leftDep + 1, rightDep + 1);
	}
/* ac版
	private boolean isBalanced = true;

	public boolean IsBalanced_Solution2(TreeNode root) {

		getDepth(root);
		return isBalanced;
	}

	public int getDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = getDepth(root.left);
		int right = getDepth(root.right);

		if (Math.abs(left - right) > 1) {
			isBalanced = false;
		}
		return right > left ? right + 1 : left + 1;

	}
*/
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(9);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(5);
		TreeNode n9 = new TreeNode(5);
//		n1.left = n2;
//		n1.right = n3;
//		n2.left = n4;
//		n2.right = n5;
//		n5.left = n6;
//		n5.right = n7;
//		n3.left = n8;
//		n8.right = n9;
		IsBalanced_Solution(n1);

	}

}
