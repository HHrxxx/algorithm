package offer;

import java.util.ArrayList;

/**
 * 	B是不是A的子结构
 *	
 *	1)找到val一样的节点，存下来
 *	2)进行一一匹配
 *
 *	若root1!=null root==null---->true
 *
 */
public class _tree_HasSubtree {
	

	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	public static ArrayList<TreeNode> rsRoot=new  ArrayList<TreeNode>() ;
	public static boolean ans=true;
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
    
    	findroot(root1,root2);
    	for(int i =0;i<rsRoot.size();i++) {
    		ans=true;
    		isSubTree(rsRoot.get(i),root2);
    		if(ans)return true;
    	}
    	
    	return ans;
    }
    
    public static void findroot(TreeNode root1,TreeNode root2) {
		if(root1==null)return;
		if(root1.val==root2.val) {
			rsRoot.add(root1);
		}
		if(root1.left!=null)
			findroot(root1.left,root2);
		if(root1.right!=null)
			findroot(root1.right,root2);
	}
    public static void isSubTree(TreeNode n1,TreeNode n2) {
    	if(n1!=null&&n2!=null&&n1.val!=n2.val) {
    		ans=false;return;
    	}else if(n1!=null&&n2==null){
    		return;
    	}else if(n1==null&&n2!=null)  {
    		ans=false;return;
    	}
    	else if(n1==null&&n2==null) {
    		return;
    	}
		isSubTree(n1.left,n2.left);
		if(!ans)return;
		isSubTree(n1.right,n2.right);
	}
     
    /*	高分ac版
     * 	不用list存储，直接遍历，找到val相同就调用函数，否则.left/.right继续寻找
     */
    public static boolean HasSubtree2(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val){
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left,root2);
            }
             
            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right,root2);
               }
            }
            //返回结果
        return result;
    }
 
    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {  
                return false;
        }
         
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left,node2.left) && doesTree1HaveTree2(node1.right,node2.right);
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
		if(HasSubtree(n1,n8)) {
			System.out.print("true");
		}

	}

}
