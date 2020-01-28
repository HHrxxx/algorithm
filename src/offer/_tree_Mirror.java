package offer;

/**
 * 	
 * 交换左右子树
 *
 */
public class _tree_Mirror {


	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
    public static void Mirror(TreeNode root) {
        if(root==null) return;
        
    	TreeNode temp=root.left;
    	root.left=root.right;
    	root.right=temp;
        Mirror(root.left);
        Mirror(root.right);
    }
   
    
	public static void main(String[] args) {
		TreeNode n1=new TreeNode(8);
		TreeNode n2=new TreeNode(8);
		TreeNode n3=new TreeNode(7);
		TreeNode n4=new TreeNode(9);
		TreeNode n5=new TreeNode(2);
		TreeNode n6=new TreeNode(4);
		TreeNode n7=new TreeNode(7);
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		n5.left=n6;
		n5.right=n7;
		TreeNode n8=new TreeNode(8);
		TreeNode n9=new TreeNode(9);
		TreeNode n10=new TreeNode(2);
		n8.left=n9;
		n8.right=n10;
		Mirror(n1);


	}

}
