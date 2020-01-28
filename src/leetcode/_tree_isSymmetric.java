package leetcode;

/**
 *	对称树
 *
 */

public class _tree_isSymmetric {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
    	
        return isTrue(root.left,root.right);
    	
 
    }
    public static boolean isTrue(TreeNode root1,TreeNode root2) {
        
    	if(root1==null&&root2==null)return true;
    	
    	if(root1==null||root2==null)return false;
    	
    	if(root1.val==root2.val) {
    				return isTrue(root1.left,root2.right)&&isTrue(root1.right,root2.left);
    	}else {
    		return false;
    	}
    	
    }

	public static void main(String[] args) {
		TreeNode n1=new TreeNode(3);
		TreeNode n2=new TreeNode(9);
		TreeNode n3=new TreeNode(9);
		TreeNode n4=new TreeNode(1);
		TreeNode n5=new TreeNode(1);
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n3.right=n5;
		

		System.out.println(isSymmetric(n1));
	}

}
