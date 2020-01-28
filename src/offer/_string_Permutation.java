package offer;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列
 *
 *	从下标0开始，依次和后续交换，下一次递归时i+1
 *	"abc"为例子
 *	
 *	第一个下标			abc	
 *	i+1=1 		 abc     	 bac 		 cba
 *				/	\		/	\		/  \
 *			  abc   acb	   bac  bca    cba cab
 *
 */

public class _string_Permutation {

	static ArrayList<String> ans = new ArrayList<String>();

	public static ArrayList<String> Permutation(String str) {
		if (str == "")
			return ans;
		all(str.toCharArray(), 0);
		Collections.sort(ans);// 按照字典序列！！！
		return ans;
	}

	public static void all(char[] str, int i) {
		if (i == str.length - 1) {
			if (!ans.contains(String.valueOf(str))) {
				ans.add(String.valueOf(str));
			}
			return;
		}
		for (int j = i; i < str.length; i++) {
			swap(str, i, j);
			all(str, j + 1);
			swap(str, j, i);
		}

	}

	public static void swap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}

	public static void main(String[] args) {
		Permutation("abc");
	}
}
