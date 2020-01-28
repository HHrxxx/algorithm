package offer;

import java.util.ArrayList;
/**
 * 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 两个指针 头尾移动 找到s==sum 最小
 */
public class _array_FindNumbersWithSum {
	
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> ans=new ArrayList<Integer>();
		if(array.length==0)return ans;
		int p=0,r;
		r=array.length-1;
		while(p!=r) {
			int s=array[p]+array[r];
			if(s==sum) {
				ans.add(array[p]);
				ans.add(array[r]);
				break;
			}else if(s<sum) {
				p++;
			}else {
				r--;
			}		
		}     	
		return ans;
    }

	public static void main(String[] args) {
		FindNumbersWithSum(new int[] {2,4,12,13,25},11);
	}

}
