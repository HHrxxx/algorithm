package offer;

import offer._linkedList_invertedOrderPrint.ListNode;
/**
 * 	 输出该链表中倒数第k个结点
 *
 *	设置 步长 用两个变量
 */
public class _linkedList_FindKthToTail {
	
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
    public static ListNode FindKthToTail(ListNode head,int k) {
    	int g=0;
    	ListNode pre=head;	
    	while(head!=null) {
    		if(g>=k) {
    			pre=pre.next;
    		}
    		g++;
    		head=head.next;
    	}
    	if(g<k)return null;
    	return pre;
    }


	public static void main(String[] args) {
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(4);
		ListNode n3=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		FindKthToTail(n1,4);

	}

}
