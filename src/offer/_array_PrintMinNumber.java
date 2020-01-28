package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * 	打印能拼接出的所有数字中最小的一个
 * @author hrx
 * 
 *  运用Collections容器
 *  关键点：拼接之后进行对比
 *
 */
public class _array_PrintMinNumber {
	
    public static String PrintMinNumber(int [] numbers) {
    	ArrayList<String> list=new ArrayList<String>();
    	for (int i = 0; i < numbers.length; i++) {
			list.add(String.valueOf(numbers[i]));
		}
    	Collections.sort(list,new Comparator<String>() {
    		public int compare(String s1, String s2) {
    			String str1=s1+s2;//
    			String str2=s2+s1;//
    			if(str1.compareTo(str2)>0) return 1;
    			else if(str1.compareTo(str2)<0) return -1;
    			else return 0;
    		};
		});
    	String rs="";
    	for (int i = 0; i < list.size(); i++) {
			rs+=list.get(i);
		}
    	return rs;
    }
    
	public static void main(String[] args) {
		System.out.print(PrintMinNumber(new int[] {1,1,21}));
	}

}
