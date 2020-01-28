package leetcode;

/**
 * 	数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 *	 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 	顺藤摸瓜：更新边界，即能到的最远距离，到达边界step++，
 *
 */
public class _array_jump {

	public static int jump(int[] nums) {

		int maxPos = 0;
		int step = 0;
		int last=0;
		for (int i = 0; i < nums.length-1; i++) {
			maxPos=Math.max(maxPos, nums[i]+i);//能跳到的最远距离
			if(i==last) {//边界
				last=maxPos;System.out.println(last);
				step++;
			}
		}
		return step;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 1, 1, 4 };
		System.out.println(jump(arr));
	}

}
