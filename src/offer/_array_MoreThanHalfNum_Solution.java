package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 * 
 * @author hrx
 *
 */
public class _array_MoreThanHalfNum_Solution {

	public static int MoreThanHalfNum_Solution(int[] array) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				int cnt = map.get(array[i]);
				map.put(array[i], cnt + 1);
			} else {
				map.put(array[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> item : map.entrySet()) {
			if (item.getValue() > array.length / 2)
				return item.getKey();
		}
		return 0;

	}

	public static void main(String[] args) {
		System.out.print(MoreThanHalfNum_Solution(new int[] { 1, 2, 3, 2, 2, 2, 5, 4, 2 }));
	}

}
