package leetcode;
import java.util.Arrays;
/**
 *	 目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *  
 *  	输入: [1,2,3], [1,1]     输出: 1
解释: 
你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
所以你应该输出1。

 *
 */
public class _array_findContentChildren {

	public  static int findContentChildren(int[] g, int[] s) {
		int cnt = 0;
		Arrays.sort(g);// child
		Arrays.sort(s);// cookies
		int j = 0;
		for (int i = 0; i < g.length&&j<s.length; i++) {
			if (g[i] <= s[j]) {// 可以满足
				cnt++;
			} else {
				i--;
			}
			j++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		
		int[] g=new int[] {1,2};
		int[] s=new int[] {1,2,3};
		System.out.println(findContentChildren(g, s));

	}

}
