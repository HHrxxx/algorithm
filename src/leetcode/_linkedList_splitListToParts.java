package leetcode;
/**
 * 	分割链表
 *  1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 *  
 *
 */
public class _linkedList_splitListToParts {
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode[] splitListToParts(ListNode root, int k) {

		ListNode[] rs=new ListNode[k];
		if(k==1) {
			rs[0]=root;
			return rs;
		}
		ListNode node=root;
		int len=0;
		while(root!=null) {
			len++;
			root=root.next;
		}
		int size=len/k;
		int mod=len%k;
		root=node;
		for (int i = 0; i <k; i++) {
			rs[i]=root;
			for (int j = 0; j < size-1; j++) {
				root=root.next;
			}
			if(size!=0&&mod!=0) {//将mod分到前面的每一组
				root=root.next;
				mod--;
			}
			if(root!=null) {
				ListNode temp=root.next;
				root.next=null;
				root=temp;
			}else {
				root=null;
			}
			
		}
		
		
		return rs;
	}

	public static void main(String[] args) {
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
//		ListNode n4=new ListNode(4);
//		ListNode n5=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
//		n3.next=n4;
//		n4.next=n5;
		splitListToParts(n1,4);
		
	}

}
