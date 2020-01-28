package leetcode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *	1->2->3->3->4->4->5
 *	1->2->5
 * 
 */
public class _linkedList_deleteDuplicates_II {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		if(head.val==head.next.val) {
			ListNode p=head.next;
			while(p!=null&&p.val==head.val) {
				p=p.next;
			}
			return deleteDuplicates(p);
		}else {
			head.next=deleteDuplicates(head.next);
			return head;
		}
	}

	public static void main(String[] args) {
		ListNode n1=new ListNode(0);
		ListNode n2=new ListNode(1);
		ListNode n3=new ListNode(1);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		deleteDuplicates(n1);

	}

}
