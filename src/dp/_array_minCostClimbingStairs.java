package dp;
import java.util.Arrays;

/**
 *	 第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0/1开始)
 *	可以选择继续爬一个阶梯或者爬两个阶梯2
 *
 *	dp[i]=Math.min(dp[i-1], dp[i-2])+cost[i-1]
 */

public class _array_minCostClimbingStairs {

	public static int minCostClimbingStairs(int[] cost) {

		if(cost.length==1)return cost[0];
		
		int[] dp=new int[cost.length+1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		dp[1]=cost[0];
		for (int i = 2; i <dp.length; i++) {
			dp[i]=Math.min(dp[i-1], dp[i-2])+cost[i-1];
		}
		
		return Math.min(dp[cost.length], dp[cost.length-1]);
	}

	public static void main(String[] args) {
		int[] arr=new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(minCostClimbingStairs(arr));
	}

}
