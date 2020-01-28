package offer;

import offer._linkedList_FindKthToTail.ListNode;

/**
 * 	反转链表后，输出新链表的表头
 * 
 *	头插法/递归
 */
public class _linkedList_ReverseList {

	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public static ListNode ReverseList(ListNode head) {
		ListNode node=new ListNode(0);
		
		while(head!=null) {
			ListNode t=head.next;
			head.next=node.next;
			node.next=head;
			head=t;
		}
		return node.next;


    }
	public static void main(String[] args) {
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(4);
		ListNode n3=new ListNode(5);
		ListNode n4=new ListNode(8);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		ReverseList(n1);

	}

}
