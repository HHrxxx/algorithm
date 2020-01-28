package leetcode;

/**
 * 
 * 	给出两个 非空 的链表用来表示两个非负的整数。
 * 	其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *	如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 *	正常进位运算解答
 */

public class _2_addTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode head = node;
		int carryBit = 0;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				ListNode n = new ListNode((l1.val + l2.val + carryBit) % 10);
				carryBit = (l1.val + l2.val + carryBit) / 10;
				node.next = n;
				l1 = l1.next;
				l2 = l2.next;
			} else if (l1 != null) {
				ListNode n = new ListNode((l1.val + carryBit) % 10);
				carryBit = (l1.val + carryBit) / 10;
				node.next = n;
				l1 = l1.next;
			} else if (l2 != null) {
				ListNode n = new ListNode((l2.val + carryBit) % 10);
				carryBit = (l2.val + carryBit) / 10;
				node.next = n;
				l2 = l2.next;
			}
			node = node.next;
		}
		if (l1 == null && l2 == null&&carryBit!=0) {
			ListNode n = new ListNode(carryBit % 10);
			node.next = n;
		}

		return head.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		 ListNode n2=new ListNode(4);
		 ListNode n3=new ListNode(3);
		ListNode n4 = new ListNode(5);
		 ListNode n5=new ListNode(6);
		 ListNode n6=new ListNode(4);
		n1.next=n2;
		n2.next=n3;
		n4.next=n5;
		 n5.next=n6;
		ListNode rs = addTwoNumbers(n1, n4);
	}

}
