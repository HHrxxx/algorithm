package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 	找出它们的第一个公共结点
 *
 */
public class _linkedList_FindFirstCommonNode {

	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	Map<ListNode,Integer> map=new HashMap<ListNode,Integer>();
    	while(pHead1!=null) {
    		map.put(pHead1, 1);
    		pHead1=pHead1.next;
    	}
    	while(pHead2!=null) {
    		if(map.containsKey(pHead2)) 
    			return pHead2;
    		pHead2=pHead2.next;
    	}
    	return null;
    }

	public static void main(String[] args) {
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(3);
		ListNode n3=new ListNode(5);
		ListNode n4=new ListNode(2);
		ListNode n5=new ListNode(4);
		ListNode n6=new ListNode(6);
		n1.next=n2;
		n2.next=n3;
		n4.next=n2;
		//n5.next=n6;
		FindFirstCommonNode(n1,n4);
	}

}
