package leetcode;

import java.util.ArrayList;

/**
 * 
 * 	将一个给定字符串根据给定的行数，
 * 	以从上往下、从左到右进行 Z 字形排列
 *
 *	 找规律 用list存储
 */
public class _6_ZigZagConversion {

	
    public static String convert(String s, int numRows) {

    	ArrayList<String> listAll=new ArrayList<String>();
    	for(int i=0;i<numRows;i++) {
    		String list =new String();
    		listAll.add(list);
    	}
    	
       	int m=0;
    	while(m<s.length()) {
    		for(int i=0;i<numRows&&m<s.length();i++) {
    			String rowData=listAll.get(i);
    			rowData+=s.charAt(m++);
    			listAll.set(i, rowData);
        	}
    		for(int i=numRows-2;i>0&&m<s.length();i--) {
    			String rowData=listAll.get(i);
    			rowData+=s.charAt(m++);
    			listAll.set(i, rowData);
        	}
    	}
    	String str="";
    	for(int i=0;i<numRows;i++) {
    		str+=listAll.get(i);
    	}
    	
    	return str;
    }
	public static void main(String[] args) {
		System.out.println(convert("LEETCODEISHIRING",4));
	}

}
