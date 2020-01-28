package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 	给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合
 * 
 *	递归 全排列
 */

public class _17_LetterCombinationsOfAPhoneNumber {
	
	public static List<String> strAns=new ArrayList<String>();
	static String []strValue= {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public static List<String> letterCombinations(String digits) {
		if(digits.length()==0)return new ArrayList<String>();
		getAnsStringList(digits,0,"");
		return strAns;
	}
	
	public static void getAnsStringList(String str,int idx,String ans) {
		if(idx==str.length()) {
			strAns.add(ans);
			return;
		}
		String s=strValue[str.charAt(idx)-'2'];
		for(int i=0;i<s.length();i++) {
			getAnsStringList(str,idx+1,ans+s.charAt(i));
		}
		
	}

	public static void main(String[] args) {
		letterCombinations("");

	}

}
