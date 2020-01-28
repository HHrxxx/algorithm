package leetcode;

/**
 * 	查找字符串数组中的最长公共前缀。
 *	
 *	缩小的概念去寻找
 */
public class _14_LongestCommonPrefix {
	
    public static String longestCommonPrefix(String[] strs) {

    	if(strs.length==0) return "";
    	String maxPre=strs[0];
        for(int j=1;j<strs.length;j++) {
        	int idx=0;
        	for(int m=0;m<maxPre.length()&&m<strs[j].length();m++) {
        		if((strs[j].charAt(m)==maxPre.charAt(m))) {
        			idx++;
        		}
        		else break;
        	}
        	maxPre=maxPre.substring(0, idx);
        }
    	return maxPre;
    }

	public static void main(String[] args) {
		//String []str= {"dog","racecar","car"};
		String []str= {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(str));
	}
}
