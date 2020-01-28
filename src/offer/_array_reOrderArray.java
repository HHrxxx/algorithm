package offer;

import java.util.Arrays;

/**
 * 		所有的奇数位于数组的前半部分，
 *  	所有的偶数位于数组的后半部分，
 *   	并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 	原数组内进行插入排序，排序条件为：奇偶性
 */
public class _array_reOrderArray {

	public static void reOrderArray(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int compIdx = i - 1;
			while (compIdx >= 0 && array[compIdx] % 2 != array[i] % 2) {
				compIdx--;
			}
			if (compIdx == -1 && array[i] % 2 == 0) {//特殊性
				continue;
			}
			int temp = array[i];
			for (int j = i; j > compIdx + 1; j--) {
				array[j] = array[j - 1];
			}
			array[compIdx + 1] = temp;

		}
	
	}

	public static void main(String[] args) {
		int[] arr=new int[] { 0, 2, 3, 4, 5, 6, 7 };
		reOrderArray(arr);
		System.out.println(Arrays.toString(arr));

	}

}
