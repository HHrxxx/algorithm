package offer;

/**
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
 *
 * 1、字符串拼接
 * 2、子串翻转---->整体翻转、
 */
public class _string_LeftRotateString {

	public static String LeftRotateString(String str, int n) {
//    	if(str.length()==0||n%str.length()==0)return str;
//        String s1=str.substring(n, str.length());
//        String s2=str.substring(0, n);    
//        System.out.println("s1"+s1);
//        System.out.println("s2"+s2);
//    	 return s1+s2;

		char[] chars = str.toCharArray();
		if (chars.length < n) {
			return "";
		}
		reverse(chars, 0, n - 1);
		System.out.println(chars);
		reverse(chars, n, chars.length - 1);
		System.out.println(chars);
		reverse(chars, 0, chars.length - 1);

		return new String(chars);

	}

	public static void reverse(char[] chars, int start, int end) {
		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		System.out.print(LeftRotateString("abcXYZdef", 5));
	}
}
