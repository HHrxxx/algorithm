import java.util.ArrayList;
import java.util.Stack;

public class TreeOrder {

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	/**
	 * 先序遍历
	 * 
	 * @param root
	 */
	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}

			System.out.print(node.val + " ");

		}
	}

	/**
	 * 中序列遍历
	 * 
	 * @param root
	 */
	public static void inOrder(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				System.out.print(root.val + " ");
				root = root.right;
			}
		}

	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 */
	public static void postOrder(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		while (root != null || !stack1.isEmpty()) {
			while (root != null) {
				stack1.push(root);
				stack2.push(root);
				root = root.right;
			}
			if (!stack1.isEmpty()) {
				root = stack1.pop().left;
			}
		}
		while (!stack2.isEmpty())
			System.out.print(stack2.pop().val + " ");
	}

	/**
	 * 层次遍历
	 * 
	 * @param root
	 */
	public static void levelOrder(TreeNode root) {
		if(root==null) return ;
		ArrayList<TreeNode> list=new ArrayList<TreeNode>();
		list.add(root);
		while(list.size()!=0) {
			TreeNode node=list.remove(0);
			System.out.print(node.val+" ");
			if(node.left!=null) {
				list.add(node.left);
			}
			if(node.right!=null) {
				list.add(node.right);
			}
		}
		
		
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
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
//		preOrder(n1);
//		inOrder(n1);
//		postOrder(n1);
		levelOrder(n1);
	}

}
