package dp;
/**
 *	需要 n 阶你才能到达楼顶。
 *	每次可以爬 1 或 2 个台阶
 *
 */
public class _int_climbStairs {

    public static int climbStairs(int n) {
    	if(n<=3)return n;
    	
    	int[] dp=new int[n+1];
    	dp[0]=0;
    	dp[1]=1;
    	dp[2]=2;
    	dp[3]=3;
    	
        for (int i = 4; i <=n; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
        return dp[n];
    }
	public static void main(String[] args) {
		System.out.println(climbStairs(4));
	}

}
