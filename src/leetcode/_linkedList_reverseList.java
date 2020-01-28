package leetcode;
/**
 * 反转链表
 */
public class _linkedList_reverseList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * 递归法1  7.94% ？？？？？？
	 */
	public static ListNode dummyHead = new ListNode(0);
	public static ListNode H = dummyHead;

	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		} else if (head.next != null) {
			reverseList(head.next);
		}

		head.next = dummyHead.next;
		dummyHead.next = head;
		dummyHead = dummyHead.next;

		return H.next;
	}
	/**
	 * 递归法2 67%
	 * @param head
	 * @return
	 */
	public static ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}

	/**
	 * 头插法 迭代？ 原地反转链表
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode reverseList2(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		while (head != null) {
			ListNode t = head.next;
			head.next = dummyHead.next;
			dummyHead.next = head;
			head = t;

		}
		return dummyHead.next;
	}

	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
//		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
//		n5.next = n6;
		reverseList(n1);

	}

}
