package offer;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 	从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 	即：层次遍历
 *
 */
public class _tree_PrintFromTopToBottom {
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }

	}
	
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) { 
    	LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
    	ArrayList<Integer> rs=new ArrayList<Integer>();
    	if(root==null)return rs;
    	queue.add(root);
    	rs.add(root.val);
    	while(!queue.isEmpty()) {
    		TreeNode n=queue.remove();
    		if(n.left!=null) { queue.add(n.left);rs.add(n.left.val);}
    		if(n.right!=null) {queue.add(n.right);rs.add(n.right.val);}		
    	}
    	return rs;
    }

	public static void main(String[] args) {
		TreeNode n1=new TreeNode(8);
		TreeNode n2=new TreeNode(8);
		TreeNode n3=new TreeNode(7);
		TreeNode n4=new TreeNode(9);
		TreeNode n5=new TreeNode(2);
		TreeNode n6=new TreeNode(4);
		TreeNode n7=new TreeNode(7);
		TreeNode n8=new TreeNode(1);
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		n5.left=n6;
		n5.right=n7;
		n3.right=n8;
		PrintFromTopToBottom(n1);

	}

}
