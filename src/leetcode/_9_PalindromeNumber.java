package leetcode;
/**
 * 
 *	判断一个整数是否是回文数
 *	注意：不将整数转为字符串来解决
 *
 *	有点类似第7题 用的字符串处理
 *	本题用 除+取余
 */
public class _9_PalindromeNumber {

	public static boolean isPalindrome(int x) {
		//特殊情况 以0结尾的，但除了0(是回文)；负数；
		if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
		int rs=0;
		while(rs<x) {
			rs=x%10+rs*10;
			x=x/10;
		}
		if(x==rs||rs/10==x)
			return true;
		else
			return false;
    }
	
	public static void main(String[] args) {

		isPalindrome(7);

	}

}
