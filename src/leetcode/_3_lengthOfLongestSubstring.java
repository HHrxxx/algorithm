package leetcode;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * String中的contains函数判断
 */
public class _3_lengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		String str = "";
		char []c=s.toCharArray();
		int i=0;
		int beginIndex=0;
		int maxLength=0;
		while(i!=s.length()) {
			if(str.contains(String.valueOf(c[i]))){//exist
				beginIndex++;
				i=beginIndex;			
				str=String.valueOf(c[i]);
			}else {
				str+=String.valueOf(c[i]);
			}
			if(str.length()>maxLength)
				maxLength=str.length();
			i++;
		}

		return maxLength;
	}

	public static void main(String[] args) {
		System.out.print(lengthOfLongestSubstring(""));
	}

}
