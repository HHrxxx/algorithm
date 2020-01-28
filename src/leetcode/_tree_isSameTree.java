package leetcode;
/**
 * 相同的树
 *
 * 类似：判断是否是对称的树。代码上来说 基本相同 ，转换一下对比的节点即可
 */
public class _tree_isSameTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        
        return (q.val==p.val)&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
