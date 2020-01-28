package offer;

import java.util.ArrayList;


public class _tree_LevelPrint {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}

	static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		
		ArrayList<ArrayList<Integer>> ans =new ArrayList<ArrayList<Integer>>();
		if(pRoot==null)return ans;
		
		ArrayList<TreeNode>  list=new ArrayList<TreeNode>();
		list.add(pRoot);
		
		while(list.size()!=0){
			
			ArrayList<Integer> t=new ArrayList<Integer>();
			ArrayList<TreeNode> nextList=new ArrayList<TreeNode>();
			
			while(list.size()!=0){
				TreeNode node=list.remove(0);
				t.add(node.val);
				if(node.left!=null) nextList.add(node.left);
				if(node.right!=null) nextList.add(node.right);
			}
			ans.add(t);
			list=nextList;
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
