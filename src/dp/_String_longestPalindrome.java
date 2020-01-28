package dp;

/**
 * 	给定一个字符串 s，找到 s 中最长的回文子串 
 * 	若s[i]==s[j] 那么dp[i][j]=dp[i+1][j-1] 只要这个区间是回文即可
 *	若s[i]!=s[j] 那么dp[i][j]肯定不是回文，即dp[i][j]=0
 *	
 *	dp[i][i+1]=s[i]==s[j]?1:0
 */
public class _String_longestPalindrome {

	public static String longestPalindrome(String s) {
		
		if (s == null || s.length() == 0)//边界情况判断
			return s;
		
		String str = "";
		int len = s.length();
		int maxLen = 1;
		int maxStart = 0;
		int[][] dp = new int[len][len];
		
		for (int i = 0; i < dp.length; i++) {// 对数组进行初始化
			dp[i][i] = 1;
			if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 1;
				maxLen = 2;
				maxStart = i;
			}
		}
		
		for (int k = 3; k <= len; k++) {// 长度至少是3开始
			for (int i = 0; i + k - 1 < len; i++) {
				int j = i + k - 1;
				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
					dp[i][j] = 1;
					
					if ((j - i + 1) > maxLen) {//记录下max及开始index
						maxLen = j - i + 1;
						maxStart = i;
					}
				}
			}
		}
		str = s.substring(maxStart, maxStart + maxLen);

		return str;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("ccc"));
	}

}
