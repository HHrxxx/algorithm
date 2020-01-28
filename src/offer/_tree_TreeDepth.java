package offer;

public class _tree_TreeDepth {

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
	static int dep=0;
	public static int TreeDepth(TreeNode root) {
		Depth(root,0);
		return dep;
	}
	public static void Depth(TreeNode root,int d) {
		if(root==null) {
			dep=Math.max(dep, d);
			return;
		}
		Depth(root.left,d+1);
		Depth(root.right,d+1);
		
	}

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
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.left = n6;
		n5.right = n7;
		n3.left = n8;
		n8.right = n9;
		System.out.print(TreeDepth(n1));

	}

}
