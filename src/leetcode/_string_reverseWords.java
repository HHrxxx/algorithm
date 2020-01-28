package leetcode;

public class _string_reverseWords {

	public static String reverseWords(String s) {
	
		String rs="";
		String str="";
		String[] arr=new String[100000];
		int m=0;
		//分割
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==' '&&str.length()>0) {
				arr[m++]=str;
				str="";
			}else if(s.charAt(i)!=' '){
				str+=s.charAt(i);
			}
		}
		if(str.length()>0) {
			arr[m++]=str;
		}
		//交换
		for (int i = 0; i < m/2; i++) {
			String s1=arr[i];
			arr[i]=arr[m-i-1];
			arr[m-i-1]=s1;
		}
		//遍历
		for (int i = 0; i <m; i++) {
			rs+=arr[i];
			if(i!=m-1)
				rs+=" ";
		}
		
		return rs;
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
	}

}
