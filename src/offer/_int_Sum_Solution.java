package offer;

/**
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 */
public class _int_Sum_Solution {

	/*等差数列求和公式
	 * Sn=na1+n(n-1)d/2
	 * a1=1 d=1
	 * 
	 * sn=(n^2+n)/2
	 * 
	*/
	public static int Sum_Solution1(int n) {
		return (int)(Math.pow(n,2)+n)>>1;
	}
	/*
	 * 递归 短路结束
	 */
	public static int Sum_Solution2(int n) {
//	    int ans = n;
//      ans&&(ans += Sum_Solution2(n - 1));
//      return ans;
		boolean flag = (n>0)&&(n+=Sum_Solution2(n-1))>0;
	    return n;
	}

	public static void main(String[] args) {
		System.out.println(Sum_Solution1(5));
		System.out.print(Sum_Solution2(5));
	}

}
