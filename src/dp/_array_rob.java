package dp;

public class _array_rob {

    public static int rob(int[] nums) {

    	int len = nums.length;
        if(len == 0)
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[len];

    }
    
	public static void main(String[] args) {

		int[] nums=new int[] {1,3,1,1,5};
		System.out.println(rob(nums));

	}

}
