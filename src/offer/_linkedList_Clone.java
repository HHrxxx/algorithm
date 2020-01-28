package offer;

/**
 * 输入一个复杂链表
 *（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head
 * 
 * 1、clone每一个节点
 * 2、连接random。
 * 3、拆分链表
 *
 */

public class _linkedList_Clone {
	
	public static class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}

    public static RandomListNode Clone(RandomListNode pHead){
    	if(pHead==null)return null;
    	RandomListNode head=pHead;
    	RandomListNode ans=new RandomListNode(0);
    	//复制节点
    	while(pHead!=null) {
    		RandomListNode p=new RandomListNode(pHead.label);
    		p.next=pHead.next;
    		pHead.next=p;
    		pHead=p.next;
    	}
    	pHead=head;
    	//连接random
    	while(pHead!=null) {
    		if(pHead.random!=null) {
    			pHead.next.random=pHead.random.next;
    		}
    		pHead=pHead.next.next;  		
    	}
    	pHead=head;
    	head=ans;
    	//拆分
    	while(pHead!=null) {
    		ans.next=pHead.next;
    		pHead.next=ans.next.next;
    		pHead=pHead.next;  	
    		ans=ans.next;
    	}
    	
    	return head.next;
    }

	public static void main(String[] args) {
	
		RandomListNode n1=new RandomListNode(1);
		RandomListNode n2=new RandomListNode(2);
		RandomListNode n3=new RandomListNode(3);
		RandomListNode n4=new RandomListNode(4);
//		RandomListNode n5=new RandomListNode(0);
//		RandomListNode n1=new RandomListNode(0);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n1.random=n4;
		n3.random=n2;
		Clone(n1);
	
		
	}

}
