package offer;
/**
 *  二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 *  从而使得内存中建立起来的二叉树可以持久保存。
 *  
 *  前序 建树
 *
 */

public class _tree_Serialize {

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	static int index;
	static String str = "";
	static String Serialize(TreeNode root) {
		
		if (root == null) {
			str += "#,";
			return str;
		}
		str += root.val+",";
		Serialize(root.left);
		Serialize(root.right);

		return str;
	}

	static TreeNode Deserialize(String str) {

		if (str == null) {
			return null;
		}

		index = -1;
		String[] strSeg = str.split(",");

		return DeserializeStr(strSeg);
	}

	static public TreeNode DeserializeStr(String[] strSeg) {
		index++;
		TreeNode treeNode = null;
		if (!strSeg[index].equals("#")) {
			treeNode = new TreeNode(Integer.valueOf(strSeg[index]));
			treeNode.left = DeserializeStr(strSeg);
			treeNode.right = DeserializeStr(strSeg);
		}
		return treeNode;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(10);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(9);
		TreeNode n7 = new TreeNode(11);
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
		System.out.print(Serialize(n1));
	}

}
