package leetcode;
/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *算出左右最高值，取相对于小的那个 对当前的height进行比较
 */
public class _array_trap {
	
	public static int trap(int[] height) {
		int n = height.length;
		int[] left=new int[n];
		int[] right=new int[n];
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], height[i - 1]);
		}
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i + 1]);
		}
		int water = 0;
		for (int i = 0; i < n; i++) {
			int level = Math.min(left[i], right[i]);
			water += Math.max(0, level - height[i]);
		}
		return water;
	}

	public static void main(String[] args) {
		System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}

}
