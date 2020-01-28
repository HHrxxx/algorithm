package offer;

/**
 * 	返回它的最大连续子序列的和
 * @author hrx
 *
 */
public class _array_FindGreatestSumOfSubArray {
	
    public static int FindGreatestSumOfSubArray(int[] array) {
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i =0;i<array.length;i++) {
        	sum+=array[i];
        	//当前的value 比之前的allSum都大，则从当前位置开始计算
        	if(sum<array[i])sum=array[i];
        	if(sum>maxSum)maxSum=sum;
        }
    	return maxSum;
    }

	public static void main(String[] args) {
		System.out.print(FindGreatestSumOfSubArray(new int[] {1,-2,3,10,-4,7,2,-5}));
	}

}
