package offer;
/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 */
public class _string_match {
	
	public static boolean match(char[] str, char[] pattern){
		int idx=0;
		for (int i = 0; i < str.length; i++) {
			if(idx==pattern.length)return false;
			if(str[i]==pattern[idx]||pattern[idx]=='.') {
				idx++;
				continue;
			}else {
				//不等
				if(idx+2<pattern.length&&pattern[idx+1]=='*') {
					idx=idx+2;
					i--;
				}else {
					return false;
				}
			}	
		}
		if(idx<pattern.length)return false;
		
        return true;
    }

	public static void main(String[] args) {
		char[] ch="".toCharArray();
		char[] pattern=".*".toCharArray();
		if(match(ch,pattern)) {
			System.out.print("true");
		}

	}

}
