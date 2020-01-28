package leetcode;

/**
 * 找到两个单链表相交的起始节点
 * 
 * 如果长度相同，但没有交点，则会在第一轮 尾节点同时为null 退出
 * 如果长度不同，但没有交点，则会在第二轮 尾节点同时为null 退出
 *
 */

public class _linkedList_getIntersectionNode {
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null)return  null;
		ListNode h1=headA;
		ListNode h2=headB;
		while(headA!=headB) {
			headA=headA==null?h2:headA.next;
			headB=headB==null?h1:headB.next;
		}
		return headA;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
//		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n5;
		n3.next = n4;
		n4.next = n5;
//		n5.next = n6;
		getIntersectionNode(n1,n3);

	}

}
