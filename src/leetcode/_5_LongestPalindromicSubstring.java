package leetcode;

/*
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 
 * 1、暴力解 O(n^3)
 * 2、中心向两边扩展 O(n^2)
 * 3、Manacher O(n)
*/
public class _5_LongestPalindromicSubstring {
	
	public static String longestPalindrome(String s) {
		
		String str="";
		char []c=s.toCharArray();

		String maxStr="";
		for(int i =0;i<s.length();i++) {
			for(int j=i;j<s.length();j++) {
				str+=c[j];
				if(isPalindrome(str)) {
					if(maxStr.length()<str.length()) {
						maxStr=str;
					}
				}
			}
			str="";
		}

		return maxStr;
	}
	public static boolean isPalindrome(String str) {
		int j=str.length()-1;
		char []c=str.toCharArray();
		for(int i=0;i<str.length()/2;i++,j--) {
			if(c[i]!=c[j])return false;
		}
		return true;
	}

	public static void main(String[] args) {
	
		System.out.print(longestPalindrome("cbbd"));
	}

}
