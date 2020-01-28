package leetcode;

import leetcode._linkedList_oddEvenList.ListNode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。 
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性
 *
 */

public class _linkedList_oddEvenList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode oddEvenList(ListNode head) {
		if(head==null||head.next==null)return head;
		ListNode h1=head;
		ListNode h=head;
		ListNode h2=head;
		head=head.next;
		int i=2;
		while(head!=null) {
			ListNode t=head.next;
			if(i%2==1) {//odd
				head.next=h1.next;
				h1.next=head;
				h1=h1.next;
			}else {
				head.next=h2.next;
				h2.next=head;
				h2=h2.next;
			}
			i++;
			head=t;
		}
		h2.next=null;
		return h;
	}

	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
//		ListNode n6 = new ListNode(2);
		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
		oddEvenList(n1);

	}

}
