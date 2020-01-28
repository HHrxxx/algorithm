package offer;

import java.util.ArrayList;
import java.util.Stack;
/**
 * 按照之字形打印二叉树
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推
 *
 */
public class _tree_zPrint {

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}

	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
		if(pRoot==null)return ans;
		
		Stack<TreeNode> stack1=new Stack<TreeNode>();
		Stack<TreeNode> stack2=new Stack<TreeNode>();
		
		stack1.push(pRoot);
		int level=0;
		while(!stack1.isEmpty()||!stack2.isEmpty()){
			level++;
			ArrayList<Integer> t=new ArrayList<Integer>();
			if(level%2==1){
				while(!stack1.isEmpty()){
					TreeNode node=stack1.pop();
					t.add(node.val);
					if(node.left!=null)stack2.push(node.left);
					if(node.right!=null)stack2.push(node.right);
				}
			}else{
				while(!stack2.isEmpty()){
					TreeNode node=stack2.pop();
					t.add(node.val);			
					if(node.right!=null)stack1.push(node.right);
					if(node.left!=null)stack1.push(node.left);
				}
			}
			ans.add(t);
		}
		return ans;
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
		Print(n1);
	}

}
