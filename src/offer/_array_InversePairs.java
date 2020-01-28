package offer;

import java.util.Stack;

/**
 * 如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。 输入一个数组,求出这个数组中的逆序对的总数P。 并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 *
 * 用归并排序，先2分，再merge
 */
public class _array_InversePairs {
	//error
//	public static int InversePairs(int[] array) {
//		if (array.length == 0)
//			return 0;
//		Stack<Integer> stack1 = new Stack<Integer>();
//		Stack<Integer> stack2 = new Stack<Integer>();
//		int cnt = 0;
//		stack1.push(array[0]);
//		for (int i = 1; i < array.length; i++) {
//			while (!stack1.isEmpty()) {
//				if (stack1.peek() < array[i]) {
//					stack1.push(array[i]);
//					break;
//				} else {
//					cnt++;
//					stack2.push(stack1.pop());
//				}
//			}
//			while (!stack2.isEmpty()) {
//				stack1.push(stack2.pop());
//			}
//		}
//
//		return cnt%1000000007;
//	}
	
	//归并
	
	static int cnt=0;
	public static int InversePairs(int [] array) {
	
		if(array.length>0) {	
			divide(array,0,array.length-1);
		}
		return cnt;
	}
	//2路分
	public static void divide(int [] array,int start,int end) {
		if(start>=end) {
			return ;
		}
		int mid=start+(end-start)/2;
		divide(array, start, mid);
		divide(array, mid+1, end);
		merge(array,start,end);
		
	}
	//合并
	public static void merge(int [] array,int start,int end) {
		int[] temp=new int[end-start+1];//辅助数组
		
		int mid=start+(end-start)/2;
		int i=start,j=mid+1,t=0;
		while(i<=mid&&j<=end) {
			if(array[i]<=array[j]) {
				temp[t++]=array[i];
				i++;
			}else {//array[i]>array[j]
				temp[t++]=array[j];
				j++;
				cnt = (cnt+mid-i+1)%1000000007;
			}
		}
		while(j<=end) {
			temp[t++]=array[j];
			j++;
		}
		while(i<=mid) {
			temp[t++]=array[i];
			i++;
		}
		for(int m=0;m<temp.length;m++) {
			array[start+m]=temp[m];
		}
	}

	public static void main(String[] args) {

		System.out.println(InversePairs(new int[] {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575}));
		cnt=0;
		System.out.print(InversePairs(new int[] {1,2,3,4,5,6,7,0}));
	}

}
