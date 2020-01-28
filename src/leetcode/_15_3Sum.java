package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * a + b + c = 0 找出所有满足条件且不重复的三元组
 * 
 * 1)排序，确定数组大小 2)用两个数组存储，正数 负数 3)a+b=-c 用空间来找
 * 
 * 注意边界条件(长度,都是正数or都是负数)+特殊情况(0.0.0)+重复>2的最多计算2遍
 *
 */
public class _15_3Sum {

	public static int threeSum(int[] nums) {
		List<List<Integer>> rs = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		// 边界条件直接return
		if (nums.length == 0 || nums[0] > 0 || nums[nums.length - 1] < 0)
			return 0;

		int[] positiveNum = new int[nums[nums.length - 1] + 1];
		int[] negativeNum = new int[-nums[0] + 1];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				negativeNum[-nums[i]]++;
			} else {
				positiveNum[nums[i]]++;
			}
		}

		if (positiveNum[0] >= 3) {// 特例
			List<Integer> list = new ArrayList<Integer>();
			list.add(0);
			list.add(0);
			list.add(0);
			rs.add(list);
		}
		// 正数(包括0)开始遍历
		for (int i = 0; i < positiveNum.length; i++) {
			int sum = i;
			if (positiveNum[i] == 0)
				continue;
			if (positiveNum[i] > 1 && i != 0) {
				// 这个数，在数组范围内且存在
				if ((sum * 2) < negativeNum.length && negativeNum[sum * 2] != 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(-2 * sum);
					list.add(sum);
					list.add(sum);
					rs.add(list);
				}
			}
			for (int j = i + 1; j < positiveNum.length; j++) {
				if ((sum + j) < negativeNum.length && negativeNum[sum + j] != 0 && positiveNum[j] != 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(0 - sum - j);
					list.add(sum);
					list.add(j);
					rs.add(list);
				}
			}
		}
		// 负数开始遍历
		for (int i = 1; i < negativeNum.length; i++) {
			int sum = i;
			if (negativeNum[i] == 0)
				continue;
			if (negativeNum[i] > 1) {
				if ((sum * 2) < positiveNum.length && positiveNum[sum * 2] != 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(-sum);
					list.add(-sum);
					list.add(2 * sum);
					rs.add(list);
				}
			}
			for (int j = i + 1; j < negativeNum.length; j++) {
				if ((sum + j) < positiveNum.length && positiveNum[sum + j] != 0 && negativeNum[j] != 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(0 - sum);
					list.add(-j);
					list.add(sum + j);
					rs.add(list);
				}
			}
		}

		return rs.size();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(threeSum(arr));

	}
}
