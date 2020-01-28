package offer;
/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *	
 * 镜像：左右子树交换。
 * 判断：left对应right  right对应left
 */
public class _tree_isSymmetrical {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}

    static boolean  isSymmetrical(TreeNode pRoot)
    {
    	if(pRoot==null)return false;
        return subIsSymmetrical(pRoot.left,pRoot.right);
    }
    public static boolean subIsSymmetrical(TreeNode root1,TreeNode root2) {
    	if(root1==null&&root2==null)return true;
		if((root1==null&&root2!=null)||(root1!=null&&root2==null)||root1.val!=root2.val)return false;
		
		return subIsSymmetrical(root1.left,root2.right)&&subIsSymmetrical(root1.right,root2.left);		
	}
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(5);
		TreeNode n7 = new TreeNode(4);
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
		if(isSymmetrical(n1)){
			System.out.print("true");
		}else{
			System.out.print("false");
		}
	}
}
