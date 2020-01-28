package leetcode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 分情况 m是否为1 头插法 插入的位置是在最头部
 */
public class _linkedList_reverseBetween_II {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n || head == null || head.next == null)
			return head;
		int i = 0;
		ListNode h = head;
		while (head != null && m != 1) {// 如果不是在最头部开始插入
			i++;
			if (i == m - 1) {
				break;
			}
			head = head.next;
		}
		ListNode p = null;// 反转内部的头节点
		ListNode r = null;// 反转内部的尾节点
		ListNode H = null;// 记录头插法的头节点

		if (m == 1) {// 如果是在最头部开始插入
			r = head;
			p = head;
			head = new ListNode(0);
			H = head;
		} else {
			p = head.next;
			r = head.next;
			H = head;
			head.next = null;
		}
		// 头插法
		while (p != null) {
			ListNode t = p.next;// 记录断开的下一个节点位置
			p.next = head.next;
			head.next = p;
			head = H;
			p = t;
			i++;
			if (i == n) {
				r.next = t;
				break;
			}
		}
		if (m == 1)
			return H.next;
		return h;
	}
	 public static ListNode reverseBetween2(ListNode head, int m, int n) {
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode pre = dummy;
	        for(int i = 1; i < m; i++){
	            pre = pre.next;
	        }
	        head = pre.next;
	        for(int i = m; i < n; i++){
	            ListNode nex = head.next;
	            head.next = nex.next;
	            nex.next = pre.next;
	            pre.next = nex;
	        }
	        return dummy.next;
	    }
	
	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		reverseBetween2(n1, 2, 4);

	}

}
