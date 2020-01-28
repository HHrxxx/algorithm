package offer;
/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树
 *
 *	
 */
public class _tree_reConstructBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public static int preStart=0;
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
	
		return 	reConstructSubTree(pre,in,0,pre.length-1);
	
	}
	public static TreeNode reConstructSubTree(int[] pre, int[] in,int inStart,int inEnd) {
		if(inStart>inEnd)return null;
	    TreeNode root=new TreeNode(pre[preStart]);
	   
	    for (int i = inStart; i <=inEnd; i++) {
			if(in[i]==pre[preStart]) {
				preStart++;
				root.left=reConstructSubTree(pre,in,inStart,i-1);
				root.right=reConstructSubTree(pre,in,i+1,inEnd);
				break;
			}
		}
		return root;
	}

	public static void main(String[] args) {

		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		reConstructBinaryTree(pre, in);

	}

}
