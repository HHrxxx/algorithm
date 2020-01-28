package offer;

import java.util.ArrayList;
/**
 * 给定一个数组和滑动窗口的大小，
 * 找出所有滑动窗口里数值的最大值
 * 
 * 到达size之后每次只+1，所以比较max是否过期or在范围内or当前值是max
 *
 */
public class _array_maxInWindows {
	
	public static ArrayList<Integer> maxInWindows(int [] num, int size){
		 ArrayList<Integer> ans=new ArrayList<Integer>();
		 if(num.length==0||size==0)return ans;
		 int max=num[0];
		 int maxIdx=0;
		 for (int i = 0; i < num.length; i++) {
			if(i<size&&max<num[i]) {
				max=num[i];
				maxIdx=i;
			}
			if(i==size-1) {
				ans.add(max);
			}
			if(i>=size) {
				//每次i+1
				if(maxIdx==(i-size)) {
					max=num[maxIdx+1];
					maxIdx++;
					for(int j=maxIdx+1;j<i;j++) {
						if(max<num[j]) {
							max=num[j];
							maxIdx=j;
						}
					}
				}
				if(max<num[i]) {
					max=num[i];
					maxIdx=i;
				}
				ans.add(max);
			}
		}
        return ans;
    }

	public static void main(String[] args) {
	
		maxInWindows(new int[] {2,3,4,2,6,2,5,1},8);

	}

}
