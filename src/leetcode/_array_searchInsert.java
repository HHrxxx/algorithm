package leetcode;
/**
 * 	找到插入的index或者存在的index
 *
 */
public class _array_searchInsert {

	public static int searchInsert(int[] nums, int target) {
		int i=0;
		while(i<nums.length&&nums[i]<target)i++;

		return i;
	}

	public static void main(String[] args) {

		int[] arr=new int[] {1,3,5,6};
		System.out.println(searchInsert(arr,7));

	}

}
