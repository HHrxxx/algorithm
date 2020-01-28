package offer;

/**
 * 
 * 	在一个二维数组中（每个一维数组的长度相同），
 *	 每一行都按照从左到右递增的顺序排序，
 *	 每一列都按照从上到下递增的顺序排序。
 * 	请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *	解题：只关注横向 ，找到行后进行二分查找
 *
 *	好的思路： 从左下角开始遍历寻找
 *	public boolean Find(int [][] array,int target) {
	int len = array.length-1;
        int i = 0;
        while((len >= 0)&& (i < array[0].length)){
            if(array[len][i] > target){
                len--;
            }else if(array[len][i] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
 *
 */
public class _array_findValue {

	public static boolean Find(int target, int[][] array) {
	
		for (int i = 0; i < array.length; i++) {
			int m = -1;
			if(array[i].length==0)break;
			if (target >= array[i][0] && target <= array[i][array[i].length - 1]) {
				m = i;
			}
			int low, high, mid;
			low = 0;
			if (m != -1) {
				high = array[m].length - 1;
				while (low <= high) {
					mid = (low + high) / 2;
					if (target < array[m][mid])
						high = mid - 1;
					else if (target > array[m][mid])
						low = mid + 1;
					else
						return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		 Find(16,new int[][]{{}});
		//Find(2, new int[][] { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } });
	}

}
