package offer;

import java.util.Scanner;

/**
 * 翻转单词顺序列 “student. a am I”---->I am a student.
 *
 *	整体先翻转再依次对单词翻转
 */
public class _string_ReverseSentence {

	public static String ReverseSentence(String str) {
		String sentence=sen(str);
		String ans="";
		int start=0;
		int cnt=0;
		for (int i = 0; i < sentence.length(); i++) {
			if(sentence.charAt(i)==' ') {
				ans+=sen(sentence.substring(start, start+cnt));
				ans+=" ";
				start=i+1;cnt=0;continue;
			}else {
				cnt++;
			}
		}
		if(cnt!=0) {
			ans+=sen(sentence.substring(start, start+cnt));
		}
		return ans;
	}
	public static String sen(String str) {
		String rs="";
		char[] ch=str.toCharArray();
		for (int i = 0; i < ch.length/2; i++) {
			char t=ch[i];
			ch[i]=ch[ch.length-1-i];
			ch[ch.length-1-i]=t;
		}
		return String.valueOf(ch);
	}


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		System.out.print(ReverseSentence(str));
	}

}
