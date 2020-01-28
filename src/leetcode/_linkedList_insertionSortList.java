package leetcode;

public class _linkedList_insertionSortList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode insertionSortList(ListNode head) {
		if(head==null||head.next==null)return head;
		

		ListNode node=new ListNode(0);
		node.next=head;
		head=head.next;
		node.next.next=null;
		while(head!=null) {
			ListNode h=node.next;
			ListNode p=node;
			ListNode t=head.next;
			while(h!=null&&head.val>h.val) {
				h=h.next;
				p=p.next;
			}
			head.next=h;
			p.next=head;
			head=t;
		}
		
		return node.next;

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
		insertionSortList(n1);

	}

}
