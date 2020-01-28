package leetcode;
/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 		 0
     	/ \
   	  -3   9
      /   /
 	-10  5
 *	
 *	快慢指针 递归
 *	每次找中点，将list分为2部分，即左右子树	
 *	注意左子树最后一个节点的next要置空。
 */
public class _linkedList_sortedListToBST {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode slow = head;
		ListNode p = new ListNode(0);
		p.next = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			p = p.next;
			fast = fast.next.next;
		}
		TreeNode node = new TreeNode(slow.val);
		node.right = sortedListToBST(slow.next);
		p.next = null;
		node.left = sortedListToBST(head);
		return node;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(-10);
		ListNode n2 = new ListNode(-3);
		ListNode n3 = new ListNode(0);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(9);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		sortedListToBST(n1);

	}

}
