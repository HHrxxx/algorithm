package offer;

/**
 * 将该二叉搜索树转换成一个排序的双向链表
 * 
 * 根据中序有序的方法，依次连接，返回head;head.left=null;处理一下
 *
 */

public class _tree_Convert {
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	public static TreeNode pre=new TreeNode(0);

	public static TreeNode Convert(TreeNode pRootOfTree) {
		TreeNode head=pre;
		if(pRootOfTree==null) return null;
		SubLinked(pRootOfTree);
		TreeNode rs=head.right;
		rs.left=null;
		return rs;
	}
	public static void SubLinked(TreeNode target) {
		if(target==null)return ;
		SubLinked(target.left);
		target.left = pre;
		pre.right = target;
		pre=target;
		SubLinked(target.right);	
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(16);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(17);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(8);
		TreeNode n6 = new TreeNode(21);
//		TreeNode n7 = new TreeNode(7);
//		TreeNode n8 = new TreeNode(5);
//		TreeNode n9 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
//		n5.left = n6;
//		n5.right = n7;
		n3.right = n6;
//		n8.right = n9;
		Convert(n1);


	}

}
