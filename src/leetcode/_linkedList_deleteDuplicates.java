package leetcode;

/**
 * 
 * 1->1->2
 * 1->2
 *
 */

public class _linkedList_deleteDuplicates {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode r=head;
		
		while(head!=null) {
			ListNode p=head.next;
			while(p!=null&&p.val==head.val) {
				p=p.next;
			}
			head.next=p;
			head=head.next;
		}
		return r;

	}
	public static void main(String[] args) {
		
		ListNode n1=new ListNode(0);
		ListNode n2=new ListNode(1);
		ListNode n3=new ListNode(1);
		ListNode n4=new ListNode(5);
		ListNode n5=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		deleteDuplicates(n1);


	}

}
