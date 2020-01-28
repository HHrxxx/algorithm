package leetcode;

/**
 * 
 * 	给出一个 32 位的有符号整数，
 * 	将这个整数中每位上的数字进行反转。
 * 	数值范围为 [−2^31,  2^31 − 1]
 * 
 * 
 * 1、用字符串交换 +java try、catch
 * 2、用%10 /10 取余 取整 
 */
public class _7_ReverseInteger {
	
	public static int reverse(int x) {
	
		String s=x>0?"":"-";
		x=x>0?x:-x;
		char [] str=String.valueOf(x).toCharArray();
		for (int i=0; i < str.length/2; i++) {
			char temp=str[i];
			str[i]=str[str.length-i-1];
			str[str.length-i-1]=temp;
		}

		String rs=s+String.valueOf(str);
		try {
			return 	Integer.valueOf(rs);
		} catch (Exception e) {
			return 0;
		}
    }

	public static void main(String[] args) {
		System.out.println(reverse(1999999999));
		System.out.println(reverse(123));
	}

}
