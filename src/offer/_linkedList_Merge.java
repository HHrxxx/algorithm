package offer;

import offer._linkedList_ReverseList.ListNode;

/**
 * 	两个单调递增的链表，
 * 	输出两个链表合成后的链表
 *
 */
public class _linkedList_Merge {

	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public static ListNode Merge(ListNode list1,ListNode list2) {
		ListNode head =new ListNode(0);
		ListNode node =new ListNode(0);
		head=node;
		while(list1!=null&&list2!=null) {
			if(list1.val>list2.val) {
				node.next=list2;
				list2=list2.next;
			}else {
				node.next=list1;
				list1=list1.next;
			}
			node=node.next;
		}
		if(list1==null)
			node.next=list2;
		else if(list2==null) {
			node.next=list1;
		}
		
		return head.next;
    }
	public static void main(String[] args) {
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(3);
		ListNode n3=new ListNode(5);
		ListNode n4=new ListNode(2);
		ListNode n5=new ListNode(4);
		ListNode n6=new ListNode(6);
		n1.next=n2;
		n2.next=n3;
		n4.next=n5;
		n5.next=n6;
		Merge(n1,n4);

	}

}
