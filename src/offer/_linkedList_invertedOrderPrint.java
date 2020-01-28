package offer;
import java.util.ArrayList;
/**
 *	 按链表值从尾到头的顺序返回一个ArrayList
 *	
 *	递归即可
 */
public class _linkedList_invertedOrderPrint {

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
    public static ArrayList<Integer> ans =new ArrayList<Integer>();
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		getAns(listNode);		
		return ans;
	}
	public static void getAns(ListNode listNode) {
		if(listNode==null)
			return ;
		getAns(listNode.next);
		ans.add(listNode.val);
	}

	public static void main(String[] args) {
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(4);
		ListNode n3=new ListNode(5);
//		n1.next=n2;
//		n2.next=n3;
		printListFromTailToHead(n1);

	}

}
