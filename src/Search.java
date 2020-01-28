
public class Search {

	/**
	 * 二分查找
	 * @param arr
	 * @param key
	 * @return
	 */
	private static int  BinSearch(int[] arr,int key) {
		int low=0;
		int high=arr.length-1;
		int mid;//=(low+high)/2;
		
		while(low<=high) {
			mid=(low+high)/2;
			if(arr[mid]>key) {
				high=mid-1;
			}else if(arr[mid]<key) {
				low=mid+1;
			}else {
				return mid+1;//返回逻辑序号
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(BinSearch(new int[] {1,4,8,9,15},4));
	}

}
