package leetcode;
/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序
 *
 */
public class _linkedList_reverseKGroup {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		
		if (head == null || head.next == null)
			return head;
		int count = 0;
		ListNode newHead = null;
		ListNode newFoot = null;
		while (count < k && head != null) {
			if (newHead == null) {
				newHead = head;
				newFoot = head;
				head = head.next;
			} else {
				ListNode temp = head;
				head = head.next;
				temp.next = newHead;
				newHead = temp;
				newFoot.next = null;
			}
			count++;
		}
		if (count == k) {
			newFoot.next = reverseKGroup(head, k);
		} else {
			return reverseKGroup(newHead, count);
		}
		return newHead;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		reverseKGroup(n1, 3);

	}

}
