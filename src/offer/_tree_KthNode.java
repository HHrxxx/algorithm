package offer;
/**
 * 二叉搜索树，请找出其中的第k小的结点
 *
 * 中序遍历
 */
public class _tree_KthNode {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
	static int kth=0;
	static TreeNode ans=null;
	static TreeNode KthNode(TreeNode pRoot, int k) {
		if(pRoot==null) return null;
		if(pRoot.left!=null) KthNode(pRoot.left,k);
		kth++;
		if(kth==k) ans= pRoot;
		if(ans!=null) return ans;
		else if(pRoot.right!=null) KthNode(pRoot.right,k);
		return  null;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(10);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(9);
		TreeNode n7 = new TreeNode(11);
//		TreeNode n8 = new TreeNode(8);
//		TreeNode n9 = new TreeNode(9);
//		TreeNode n10 = new TreeNode(10);
//		TreeNode n11 = new TreeNode(11);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;		
//		n5.left = n8;
//		n5.right = n9;		
//		n9.right = n10;
		n3.left = n6;
		n3.right = n7;	
//		n6.right = n11;	
		TreeNode rs=KthNode(n1,5);

	}

}
