package offer;
/**
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 * 
 * 下一个节点，要么是父节点(当前节点是此父节点的左孩子)
 * 要么是右子树的最左节点（该节点.left==null）
 *
 */
public class _tree_GetNext {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		TreeLinkNode next = null;

		TreeLinkNode(int val) {
			this.val = val;
		}
	}

	public static TreeLinkNode GetNext(TreeLinkNode pNode) {
		// 左右均null 则 return null
		if (pNode == null)
			return null;

		// 存在右子树，则找右子树 最左的节点为null的。
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		}else {
			// next!=null
			while (pNode.next != null) {
				if (pNode.next.left == pNode)
					return pNode.next;
				pNode = pNode.next;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		TreeLinkNode n7 = new TreeLinkNode(7);
		TreeLinkNode n8 = new TreeLinkNode(8);
		TreeLinkNode n9 = new TreeLinkNode(9);
		TreeLinkNode n10 = new TreeLinkNode(10);
		TreeLinkNode n11 = new TreeLinkNode(11);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n2.next = n1;
		n4.next = n2;
		n5.left = n8;
		n5.right = n9;
		n5.next = n2;
		n8.next = n5;
		n9.next = n5;
		n9.right = n10;
		n3.left = n6;
		n3.right = n7;
		n3.next = n1;
		n6.right = n11;
		n6.next = n3;
		n7.next = n3;
		n11.next = n6;
		n10.next = n9;

		GetNext(n7);

	}

}
