package leetcode;

import java.util.Arrays;
/**
 * 	找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
 * 	
 *	排序，根据sum值 移动头尾 idx 取最接近
 */
public class _16_3SumClosest {

	public static int threeSumClosest(int[] nums, int target) {
		
		Arrays.sort(nums);
		int closed=2147483647;
		int ans=nums[0]+nums[1]+nums[2];
		for(int i=0;i<nums.length-2;i++) {	
			for(int p=i+1, r=nums.length-1;p<r;) {
				int sum=nums[i]+nums[p]+nums[r];
				if(Math.abs(target-sum)<Math.abs(closed)) {		
					closed=Math.abs(target-sum);
					ans=sum;
				}
				if(sum>target)r--;
				else if(sum<target) p++;
				else return sum;
			}

		}

		return  ans;
	}

	public static void main(String[] args) {

		System.out.println(threeSumClosest(new int[] {
				-1,2,1,-4},1));
	}
}
