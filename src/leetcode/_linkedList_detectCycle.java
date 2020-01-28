package leetcode;

/**
 * 返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 *
 * 先判断是否有环，再找入口
 * 
 */
public class _linkedList_detectCycle {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode detectCycle(ListNode head) {
		
		if(head==null||head.next==null)return head;
		ListNode fast=head;
		ListNode slow=head;
		boolean flag=false;
		while(fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				flag=true;
				break;
			}
		}
		if(flag) {// hasCycle
			ListNode t=head;
			while(t!=slow) {
				slow=slow.next;
				t=t.next;
			}
			return slow;
		}
		return null;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
		System.out.print(detectCycle(n1).val);

	}

}
