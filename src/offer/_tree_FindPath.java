package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * 	打印出二叉树中结点值的和为输入整数的所有路径。
 * 	路径定义为从树的根结点----叶结点所经过的结点形成一条路径
 * 
 *	深度遍历 递归  
 *	注意引用传递
 */
public class _tree_FindPath {

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	public static ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();

	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return rs;
		list.add(root.val);
		isPath(root, target, root.val, list);
		Collections.sort(rs,new Comparator<ArrayList<Integer>> (){
			public int compare(ArrayList<Integer> list1,ArrayList<Integer> list2) {
					return list1.size()>list2.size()?-1:1;
			}
		});
		return rs;
	}

	public static void isPath(TreeNode root, int target, int curSum, ArrayList<Integer> list) {
		if ((root.left != null || root.right != null) && curSum > target)
			return;
		if (curSum == target && root.left == null && root.right == null) {
			rs.add(list);
			return;
		}
		
		if (root.left != null) {
			ArrayList<Integer> newList =new ArrayList<Integer>(list);
			newList.add(root.left.val);		
			isPath(root.left, target, curSum + root.left.val, newList);
		}
		if (root.right != null) {
			ArrayList<Integer> newList =new ArrayList<Integer>(list);
			newList.add(root.right.val);
			isPath(root.right, target, curSum + root.right.val, newList);
		}

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
		FindPath(n1, 25);
	}

}
