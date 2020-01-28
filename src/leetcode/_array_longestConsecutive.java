package leetcode;

import java.util.Arrays;

public class _array_longestConsecutive {

	public static int longestConsecutive(int[] nums) {
		if(nums==null)return 0;
		if(nums.length==1)return 1;
		Arrays.sort(nums);
		int[] dp=new int[nums.length];
		int index=0;
		int maxLen=0;
		int rep=0;
		for (int i = 1; i < nums.length; i++) {	
			if(nums[i-1]+1==nums[i]) {
				dp[i]=dp[i-1];
			}else if(nums[i-1]==nums[i]){
				rep++;
				dp[i]=dp[i-1];
			}else {
				dp[i]=i;
				index=i;
				rep=0;
			}
			maxLen=Math.max(maxLen, i-index+1-rep);
		}
		
		return maxLen;
	}

	public static void main(String[] args) {

		int[] arr=new int[] {1,2,3,1111,1111};
		System.out.println(longestConsecutive(arr));

	}

}
