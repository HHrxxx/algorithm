package offer;

/**
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
 *
 *	1->2->3->3->4->4->5
 *	1->2->5
 *
 *	先进行计数 直到不同，若cnt==1 则连接
 *	边界：全都是重复的，头尾重复
 */
public class _linkedList_deleteDuplication {
	
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
	
    public static ListNode deleteDuplication(ListNode pHead)
    {
    	ListNode head= new ListNode(0);
    	ListNode ans=head;
    	ListNode pre=pHead;
    	ListNode t=pre;
    	int cnt=0;
    	while(pre!=null) {
    		if(t.val==pre.val) {
    			cnt++;
    			pre=pre.next;
    		}
    		else {
    			if(cnt==1) {
    				head.next=t;
    				head=head.next;
    				head.next=null;
    				
    			}
				cnt=1;
				t=pre;
				pre=pre.next;			
    		}
    			
    	}
    	if(cnt==1) {
    		head.next=t;
			head=head.next;
			head.next=null;
    	}
    	
    	return ans.next;
    	
    }

	public static void main(String[] args) {
		ListNode n1=new ListNode(2);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(3);
		ListNode n5=new ListNode(5);
		ListNode n6=new ListNode(5);
		ListNode n7=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		deleteDuplication(n1);
	}

}
