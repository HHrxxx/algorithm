package leetcode;
import java.util.*;
/**
 * 	两数相加(链表)
 * 	输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 *	输出: 7 -> 8 -> 0 -> 7
 *
 */
public class _linkedList_addTwoNumbers {
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		Stack<ListNode> stack1=new  Stack<>();
		Stack<ListNode> stack2=new  Stack<>();
		int k=0;//记录进位
		ListNode head=new ListNode(0);//头插法 记录结果
		
		while(l1!=null) {
			stack1.push(l1);
			l1=l1.next;
		}
		while(l2!=null) {
			stack2.push(l2);
			l2=l2.next;
		}
		
		while(!stack1.isEmpty()||!stack2.isEmpty()) {
			int n1=0,n2=0;
			if(!stack1.isEmpty()) {
				n1=stack1.pop().val;
			}
			if(!stack2.isEmpty()) {
				n2=stack2.pop().val;
			}
	
			int cur=n1+n2+k;
			
			ListNode t=new ListNode(cur%10);
			t.next=head.next;
			head.next=t;
			if(cur>=10) {
				k=(cur)/10;
			}else {
				k=0;
			}
		}

		if(k!=0) {
			ListNode t=new ListNode(k);
			t.next=head.next;
			head.next=t;
		}
		
		return head.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(9);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(2);
//		n1.next=n2;
		
		addTwoNumbers(n1,n3);
	}

}
