package leetcode;



public class _linkedList_partition {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode partition(ListNode head, int x) {
		if(head==null)return head;
		
		ListNode l_Head=new ListNode(0);
		ListNode h_Head=new ListNode(0);
	
		
		ListNode h1=l_Head;
	
		ListNode h2=h_Head;
		
		while(head!=null){
			if(head.val<x) {
				l_Head.next=head;
				l_Head=l_Head.next;
			}else  {//head.val>=x
				h_Head.next=head;
				h_Head=h_Head.next;
			}
			head=head.next;
		}
		l_Head.next=h2.next;
	
		h_Head.next=null;
		return h1.next;
		
	}

	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		partition(n1,3);
	}

}
