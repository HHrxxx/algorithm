package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 
 * 用map键值对
*/
public class _1_twoSum {

	public static int [] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			int other=target-nums[i];
			if(map.containsKey(other)) {
				return new int[]{map.get(other),i};
			}
			map.put(nums[i],i);
		}
		return null;
	}

	public static void main(String[] args) {
		int nums[]= {-1,2,4,5,-2};
		System.out.print(Arrays.toString(twoSum(nums,0)));

	}

}
