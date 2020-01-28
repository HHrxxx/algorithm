package leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * 存在 0 < i < B.length - 1 
 * 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 *	
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 */

public class _array_longestMountain {

	public static int longestMountain(int[] A) {
	     
		int max=0;
		Map<Integer,Integer> map=new HashMap<>();
		
		for (int i = 0; i < A.length; i++) {
			int left=0;
			int right=0;
			map.put(A[i], 0);
			//左遍历
			for (int j = i;j>0; j--) {
				if(A[j-1]<A[j]) {
					left++;
				}else {
					break;
				}
			}
			//右遍历
			for (int j = i;j < A.length-1; j++) {
				if(A[j]>A[j+1]) {
					right++;
				}else {
					break;
				}
			}
			if(left>0&&right>0) {
				max=Math.max(max, left+right+1);
			}
			
		}
		if(map.size()==1) {
			return 0;
		}else {
			return max;
		}
    }
	public static void main(String[] args) {
		int[] arr=new int[] {2,3,2};
		System.out.println(longestMountain(arr));
	}

}
