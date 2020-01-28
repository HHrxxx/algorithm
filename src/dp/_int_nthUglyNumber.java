package dp;

/**
 * 关于丑数 丑数就是只包含质因数 2, 3, 5 的正整数
 *
 * 三个指针分别移动
 */
public class _int_nthUglyNumber {

	/**
	 * 找出第 n 个丑数。
	 * 
	 * @param n
	 * @return
	 */
	public static int nthUglyNumber(int n) {

		int[] dp = new int[n];
		int num1, num2, num3;
		num1 = num2 = num3 = 0;
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			int min = Math.min(dp[num1] * 2, Math.min(dp[num2] * 3, dp[num3] * 5));
			if (min == dp[num1] * 2)
				num1++;
			if (min == dp[num2] * 3)
				num2++;
			if (min == dp[num3] * 5)
				num3++;
			dp[i] = min;

		}
		return dp[n - 1];
	}

	/**
	 * 判断是否是丑数
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isUgly(int num) {
		if (num == 0)
			return false;
		while (num % 2 == 0) {
			num /= 2;
		}
		while (num % 5 == 0) {
			num /= 5;
		}
		while (num % 3 == 0) {
			num /= 3;
		}
		if (num == 1)
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isUgly(7));
//		System.out.println(nthUglyNumber(10));
	}

}
