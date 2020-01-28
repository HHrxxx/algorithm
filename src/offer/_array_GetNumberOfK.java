package offer;
/**
 * 	统计一个数字在排序数组中出现的次数。
 * 
 * 	二分查找 找第一个位置和最后一个位置
 *
 */
public class _array_GetNumberOfK {
	
    public static int GetNumberOfK(int [] array , int k) {
    	if(getLastIndex(array,k)==-1&&getFirstIndex(array,k)==-1)
    		return 0;
    	return getLastIndex(array,k)-getFirstIndex(array,k)+1;
    }
    public static int getFirstIndex(int [] array , int k) {
    	int startIndex=0;
    	int endIndex=array.length-1;
    	int index=-1;
    	while(startIndex<=endIndex) {
    		int mid=(startIndex+endIndex)/2;
    		if(array[mid]>k) {
    			endIndex=mid-1;
    		}else if(array[mid]<k) {
    			startIndex=mid+1;
    		}else {
    			if(mid==array.length-1)
    				return mid;
    			endIndex=mid-1;
    		}
    		if(array[mid]==k) index=mid;
    	}
    	return index;
    }
    public static int getLastIndex(int [] array , int k) {
    	int startIndex=0;
    	int endIndex=array.length-1;
    	int index=-1;
    	while(startIndex<=endIndex) {
    		int mid=(startIndex+endIndex)/2;
    		if(array[mid]>k) {
    			endIndex=mid-1;
    		}else if(array[mid]<k) {
    			startIndex=mid+1;
    		}else {
    			if(mid==array.length-1)
    				return mid;
    			startIndex=mid+1;
    		}
    		
    		if(array[mid]==k) index=mid;
    	}
    	return index;
    }
    public static void main(String[] args) {
		System.out.print(GetNumberOfK(new int[] {1,2,3,3,3,4},3));
	}

}
