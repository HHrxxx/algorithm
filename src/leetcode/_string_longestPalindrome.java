package leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串
 *
 */
public class _string_longestPalindrome {

	public static int longestPalindrome(String s) {
		//存储数量 可以用 数组 牺牲空间来存
		Map<Character,Integer> map=new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if(!map.containsKey(s.charAt(i))) {//不存在
				map.put(s.charAt(i), 1);
			}else {
				int v=map.get(s.charAt(i));
				map.put(s.charAt(i),v+1);
			}
		}
		int len=0;
		boolean flag=false;
		for(Character key:map.keySet()){
			int value=map.get(key);
			if(value%2==0) {
				len+=value;				
			}else {
				len+=value-1;
				if(s.length()%2==0) {
					flag=true;//偶数 存在有一个1 就可以了。
				}
				
			}	
		}
		if(flag) len++;
		if(s.length()%2!=0) len++;//基数+1
		
		return len;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("dccaccd"));
	}

}
