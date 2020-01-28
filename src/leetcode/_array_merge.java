package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 合并区间 先排序 之后只要对right进行处理就可以了
 *
 */
public class _array_merge {

	public static int[][] merge(int[][] intervals) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		for (int i = 0; i < intervals.length; i++) {
			int left = intervals[i][0];
			int right = intervals[i][1];
			if (!map.containsKey(left)) {
				int j = i + 1;
				for (; j < intervals.length; j++) {
					if (intervals[j][0] <= right) {
						left = Math.min(left, intervals[j][0]);
						right = Math.max(right, intervals[j][1]);
					} else
						break;
				}
				i = j - 1;
				map.put(left, right);
			}
		}
		int[][] arr = new int[map.size()][2];
		int m = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			arr[m][0] = entry.getKey();
			arr[m++][1] = entry.getValue();
		}

		return arr;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		merge(arr);
		arr = new int[][] { { 1, 4 }, { 0, 0 } };
		merge(arr);
		arr = new int[][] { { 1, 4 }, { 0, 4 } };
		merge(arr);
		arr = new int[][] { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } };
		merge(arr);
	}

}
