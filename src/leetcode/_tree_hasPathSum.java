package leetcode;



/**
 * 判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和
 *
 */

public class _tree_hasPathSum {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root==null)return false;
		
		if(root.left==null&&root.right==null) {
			return sum-root.val==0;
		}
		return hasPathSum(root.left, sum - root.val)|| hasPathSum(root.right, sum - root.val);	
	
	}

	public static void main(String[] args) {
		TreeNode n1=new TreeNode(3);
		TreeNode n2=new TreeNode(9);
		TreeNode n3=new TreeNode(20);
		TreeNode n4=new TreeNode(15);
		TreeNode n5=new TreeNode(7);

		System.out.println(hasPathSum(n1,3));
	}

}
