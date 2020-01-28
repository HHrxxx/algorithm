package leetcode;

public class _tree_buildTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static int preIndex=0;
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		
		return build(preorder,inorder,0,preorder.length-1);
	}
	public static TreeNode build(int[] pre, int[] in,int inStart,int inEnd) {
		
		if(inStart>inEnd)return null;
		TreeNode node=new TreeNode(pre[preIndex]);
		
		for (int i = inStart; i <=inEnd; i++) {
			if(in[i]==pre[preIndex]) {
				preIndex++;
				node.left=build(pre,in,inStart,i-1);
				node.right=build(pre,in,i+1,inEnd);
				break;
			}
		}
		
		return node;
		
	}

	public static void main(String[] args) {
		int[] pre = new int[] { 3, 9, 20, 15, 7 };
		int[] in = new int[] { 9, 3, 15, 20, 7 };
		buildTree(pre, in);
	}

}
