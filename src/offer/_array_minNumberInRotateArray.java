package offer;

import java.util.Arrays;

/**
 * 实际考察 二分查找
 *
 */

public class _array_minNumberInRotateArray {
	
	public static int minNumberInRotateArray(int[] array) {
		if(array.length==0)return 0;
		Arrays.sort(array);
		return array[0];
	}

	public static void main(String[] args) {
		System.out.print(minNumberInRotateArray(new int[]{3,4,5,1,2}));

	}

}
