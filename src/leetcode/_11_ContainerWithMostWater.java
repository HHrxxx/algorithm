package leetcode;

/**
 * 	头尾向中间扫描，每次保留maxheight
 * 	求出maxArea
 *
 */
public class _11_ContainerWithMostWater {
	
	public static int maxArea(int[] height) {
		
		int r=height.length-1;
		int p=0;
		int max=0;
		while(r!=p) {
			int area=Math.min(height[r], height[p])*(r-p);
			max=Math.max(max, area);
			if(height[r]>height[p]) p++;
			else r--;
		}	
		return max;
	}

	public static void main(String[] args) {
		int num[]= {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(num));
	}
}
