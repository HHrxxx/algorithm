package leetcode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表
 *
 */
public class _linkedList_swapPairs {
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null)return head;
		
		ListNode t=head.next;
		head.next=swapPairs(t.next);
		t.next=head;
		return t;
		
	}

	public static void main(String[] args) {
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		swapPairs(n1);

	}

}
