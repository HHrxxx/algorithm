package leetcode;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 
 * 归并排序
 * 
 * 递归，快慢指针找到中间
 * 进行合并
 *
 */
public class _linkedLsit_sortList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode mergeSort(ListNode head) {
		if (head==null||head.next == null)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		ListNode p = null;
		while (fast != null && fast.next != null) {
			p = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		p.next = null;
		ListNode h1 = mergeSort(head);
		ListNode h2 = mergeSort(slow);
		return merge(h1, h2);
	}

	public static ListNode merge(ListNode h1, ListNode h2) {
		ListNode head = new ListNode(0);
		ListNode H = head;
		while (h1 != null && h2 != null) {
			if (h1.val > h2.val) {
				ListNode t = h2.next;
				h2.next = head.next;
				head.next = h2;
				h2 = t;
			} else {// h1.val<=h2.val
				ListNode t = h1.next;
				h1.next = head.next;
				head.next = h1;
				h1 = t;
			}
			head = head.next;
		}
		if (h1 != null) {
			head.next = h1;
		}
		if (h2 != null) {
			head.next = h2;
		}
		return H.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
//		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
//		n5.next = n6;
		mergeSort(n1);

	}

}
