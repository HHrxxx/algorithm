package leetcode;
/**
 * 字符串的最大公因子
 *
 *	输入：str1 = "ABCABC", str2 = "ABC"
 *	输出："ABC"
 *
 *	辗转相除法
 */
public class _string_gcdOfStrings {

	public static String gcdOfStrings(String str1, String str2) {

		int len1=str1.length();
		int len2=str2.length();
		
		if(len1==len2) {
			if(str1.equals(str2)) {
				return str1;
			}else {
				return "";
			}
		}
		
		if(len1>len2) {
			str1=str1.substring(len2);
			return gcdOfStrings(str1,str2);
		}else {
			str2=str2.substring(len1);
			return gcdOfStrings(str1,str2);
		}

	}

	public static void main(String[] args) {
		System.out.println(gcdOfStrings("ABABABAB","AB"));
	}

}
