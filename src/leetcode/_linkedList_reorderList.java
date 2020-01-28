package leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 
 * 1、用快慢指针找到重点，拆分成两部分，后半部用stack压栈 
 * 2、用双端队列（优）
 */
public class _linkedList_reorderList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		ListNode fast = head;
		ListNode slow = head;
		ListNode h = new ListNode(0);
		ListNode H = h;
		ListNode r = head;
		Stack<ListNode> stack = new Stack<ListNode>();
		// 找中点
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode mid = slow;
		slow = slow.next;
		while (slow != null) {
			stack.push(slow);
			slow = slow.next;
		}
		mid.next = null;

		while (r != null) {
			h.next = r;
			h = h.next;
			r = r.next;
			if (!stack.isEmpty()) {
				h.next = stack.pop();
				h = h.next;
			}

		}
		head = H.next;
	}
	
	//双端队列
	public void reorderList1(ListNode head) {
		LinkedList<ListNode> queue = new LinkedList<>();
		ListNode cur = head;
		while (cur != null) {
			queue.addLast(cur);
			cur = cur.next;
		}
		while (!queue.isEmpty()) {
			if (cur == null) {
				cur = queue.pollFirst();
			} else {
				cur.next = queue.pollFirst();
				cur = cur.next;
			}
			cur.next = queue.pollLast();
			cur = cur.next;
		}
		if (cur != null) {
			cur.next = null;
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
		reorderList(n1);
	}

}
