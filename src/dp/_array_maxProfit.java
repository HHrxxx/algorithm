package dp;
/**
 * 	给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *	如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *	注意你不能在买入股票前卖出股票
 *
 *	Math.max(dp[i-1]+prices[i]-prices[i-1], prices[i]-prices[i-1]);
 */
public class _array_maxProfit {

    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)return 0;
        
        int[] dp=new int[prices.length];
        int max=0;
     
        for (int i = 1; i < prices.length; i++) {
        	int rs=prices[i]-prices[i-1];
			dp[i]=Math.max(dp[i-1]+rs, rs);
			max=Math.max(max,dp[i]);
		}
        return max;
    }
	public static void main(String[] args) {

		int[] n=new int[] {7,1,5,3,6,4};
		System.out.println(maxProfit(n));
	}

}
