package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 	一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 *	找出这两个只出现一次的数字。
 *	
 *	HashMap /异或 同0，异1
 */
public class _array_FindNumsAppearOnce {
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i = 0; i < array.length; i++) {
        	if(map.containsKey(array[i])) {
        		map.put(array[i], map.get(array[i])+1);continue;
        	}
        	map.put(array[i], 1);
		}
        int cnt=0;
		for (Map.Entry<Integer, Integer> item : map.entrySet()) {
			if (item.getValue()==1&&cnt==0) {
				num1[0]=item.getKey();cnt++;continue;
			}
			if (item.getValue()==1&&cnt==1) {
				num2[0]=item.getKey();
			}
		}
    }

	public static void main(String[] args) {
		FindNumsAppearOnce(new int[] {1,2,2,3,3,5,6,6},new int[] {0},new int[] {0});
	}

}
