package leetcode;



public class _linkedList_isPalindrome {
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static boolean isPalindrome(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
		ListNode dummy=new ListNode(0);
		
		while(fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		while(slow!=null) {
			ListNode t=slow.next;
			slow.next=dummy.next;
			dummy.next=slow;
			slow=t;
		}
		slow=dummy.next;
		while(slow!=null) {
			if(slow.val!=head.val)return false;
			slow=slow.next;
			head=head.next;
		}
		
		return true;
	}

	public static void main(String[] args) {
		ListNode n1=new ListNode(0);
		ListNode n2=new ListNode(1);
		ListNode n3=new ListNode(2);
		ListNode n4=new ListNode(1);
		ListNode n5=new ListNode(0);
//		n1.next=n2;
//		n2.next=n3;
//		n3.next=n4;
//		n4.next=n5;
		System.out.println(isPalindrome(null));
	}

}
