package leetcode;

/**
 * 给定一个链表，判断链表中是否有环。
 * 
 * 1、快慢指针
 * 2、对遍历过的点，给一个特殊值
 * 3、hash
 */

public class _linkedList_hasCycle {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static boolean hasCycle(ListNode head) {
		if(head==null||head.next==null)return false;
		ListNode fast=head;
		ListNode slow=head;
		
		while(fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)return true;			
		}
		
		return false;
	}

	public static void main(String[] args) {
		ListNode n1=new ListNode(0);
		ListNode n2=new ListNode(1);
		ListNode n3=new ListNode(2);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		if(hasCycle(n1)) {
			System.out.print("true");
		}

	}

}
