package offer;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * 	输入n个整数，找出其中最小的K个数
 * @author hrx
 * 
 *  运用TreeMap
 *  解法很多 关键就是排序 
 *  还可以运用partition
 *	
 */
public class _array_GetLeastNumbers_Solution {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //TreeMap解法
    	Map<Integer, Integer> map=new TreeMap<Integer,Integer>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(k>input.length)return list;
        for(int i=0;i<input.length;i++) {
    		if(map.containsKey(input[i])) {
    			int cnt=map.get(input[i]);
    			map.put(input[i], cnt+1);
    		}else {
    			map.put(input[i], 1);
    		}
    	}
        int cnt=0;
    	for (Map.Entry<Integer, Integer> item : map.entrySet()) {
    		for(int i=0;i<item.getValue()&&cnt<k;i++){
    			list.add(item.getKey());
    			cnt++;
    		}
    	}
    	
  
    	return list;
    }
    
	public static void main(String[] args) {
		GetLeastNumbers_Solution(new int[] {4,1,1,1,1,7,3,8},4);

	}

}
