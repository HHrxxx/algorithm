package offer;

import java.util.ArrayList;
import java.util.Collections;

public class _int_GetMedian {
	
	static ArrayList<Integer> list=new ArrayList<Integer>();
	
	public static void Insert(Integer num) {
		list.add(num);
    }

    public static Double GetMedian() {
    	Collections.sort(list);
        if(list.size()%2!=0) {//奇数
        	return (double)list.get(list.size()/2);
        }else {//偶数
        	double x1=(double)list.get(list.size()/2-1);
        	double x2=(double)list.get(list.size()/2);
        	return (x1+x2)/2;
        }
    }


	public static void main(String[] args) {
		Insert(1);
		Insert(2);
//		Insert(3);
		System.out.print(GetMedian());
	}

}
