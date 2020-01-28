package leetcode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 */
public class _linkedList_removeElements {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// 36.33%
//	public static ListNode removeElements(ListNode head, int val) {
//		if(head==null)return head;
//		ListNode dummyHead=new ListNode(0);
//		ListNode h=dummyHead;
//		while(head!=null) {
//			if(head.val==val) {
//				head=head.next;continue;
//			}else {
//				ListNode t=head.next;
//				head.next=dummyHead.next;
//				dummyHead.next=head;
//				head=t;
//			}	
//			dummyHead=dummyHead.next;
//		}
//		return h.next;
//	}

	public static ListNode removeElements(ListNode head, int val) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode cur = dummyHead;
		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
//		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
//		n5.next = n6;
		removeElements(n1, 2);

	}

}
