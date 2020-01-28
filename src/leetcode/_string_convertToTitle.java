package leetcode;
/**
  *  1 -> A
  *  2 -> B
  *  3 -> C
  *  ...
  *  26 -> Z
  *  27 -> AA
  *  28 -> AB 
  *  ...
  *  
  *  输入: 28
  *  输出: "AB"
  *
  */

public class _string_convertToTitle {

	static String str="";
	/**
	 * 递归
	 * @param n
	 * @return
	 */
	
	static String convertToTitle(int n) {

		if ((n - 1) / 26 > 0)
			convertToTitle((n - 1) / 26);
		return str+=String.valueOf((char) ((n - 1) % 26 + 65));
	}
	/**
	 * 非递归
	 * @param n
	 * @return
	 */
	static String convertToTitle2(int n) {

		String s = "";
        while(n > 0){
            n--;
            s = String.valueOf((char) (n % 26 + 65))+s;
            n /= 26;
        }
        return s;
	}


	public static void main(String[] args) {
		System.out.println(convertToTitle2(704));
	}

}
