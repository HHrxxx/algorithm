package offer;
/**
 * 	全部由字母组成,中找到第一个只出现一次的字符
 *	返回它的位置, 如果没有则返回 -1
 *
 */
public class _string_FirstNotRepeatingChar {
	
    public static int FirstNotRepeatingChar(String str) {
    	char[] c=str.toCharArray();
    	int[] cnt=new int [10000];
    	for (int i = 0; i < c.length; i++) {
			cnt[c[i]-65]++;
		}
    	for (int i = 0; i < c.length; i++) {
			if(cnt[c[i]-65]==1) {
				 return str.indexOf(String.valueOf(c[i]));
			}
		}
        return -1;
    }
    public static void main(String[] args) {
    	System.out.print(FirstNotRepeatingChar("google"));
	}
}
