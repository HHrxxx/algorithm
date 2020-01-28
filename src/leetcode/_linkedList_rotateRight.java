package leetcode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 解法1:将k对长度进行取余，压缩时间，之后一个一个移，直到k==0
 * 解法2:先对k压缩，遍历找到倒数第k个。用三个指针来标记，进行重新连接即可。
 */
public class _linkedList_rotateRight {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	//解法1
	public static ListNode rotateRight(ListNode head, int k) {
		if(head==null||k==0)return head;

		ListNode h=new ListNode(0);
		ListNode p=new ListNode(0);
		ListNode r=head;
		int length=0;
		while(r!=null) {
			r=r.next;
			length++;
		}
		k=k%length;
		while(k!=0) {
			if(head!=null) {
				h=head;
				p=head;
				int m=0;
				while(h.next!=null) {
					h=h.next;
					if(m>=1) {
						head=head.next;
					}
					m++;
				}
				h.next=p;
				head.next=null;
				k--;
				head=h;
			}
		}
		return head;
	}
	//解法2
	public static ListNode rotateRight1(ListNode head, int k) {
		if(head==null||k==0)return head;

		ListNode p2=head;
		ListNode p1=head;
		ListNode r=head;
		int length=0;
		while(r!=null) {
			r=r.next;
			length++;
		}
		k=k%length;
		if(k==0)return head;
		
		r=head;
		int i=1;
		while(r.next!=null) {
			r=r.next;
			i++;
			if(i>k) {
				p2=p2.next;
			}
			if(i>k+1) {
				p1=p1.next;
			}	
		}
		r.next=head;
		p1.next=null;
		return p2;
	}

	public static void main(String[] args) {
		ListNode n1=new ListNode(0);
		ListNode n2=new ListNode(1);
		ListNode n3=new ListNode(2);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
//		n3.next=n4;
//		n4.next=n5;
		rotateRight1(n1,2);

	}

}
