package offer;

import java.util.Arrays;

/**
 * 如果牌能组成顺子就输出true，否则就输出false
 * 大\小 王可以看成任何数字,认为大小王是0
 *
 *	1）边界情况：全0，空数组、无0
 *	2）判断是否有重复的
 *	3）计算0的数量 是否够填补 缺少的差值
 *
 */
public class _array_isContinuous {
	
    public static boolean isContinuous(int [] numbers) {
    	if(numbers.length==0)return false;
    	Arrays.sort(numbers);
    	int cnt=0;
    	//check 重复
    	for (int i = 0; i < numbers.length-1; i++) {
			if(numbers[i]!=0&&numbers[i]==numbers[i+1])return false;
	}
    	for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]==0)cnt++;
			else break;
		}
    	if(cnt==numbers.length)return true;
    	int min=numbers[cnt];
    	int max=numbers[numbers.length-1];
    	int dif=max-min;
    	int idxDif=Math.abs(numbers.length-1-cnt-dif);
    	return cnt>=idxDif;
    }

	public static void main(String[] args) {
		boolean rs=isContinuous(new int [] {1,5,0,0,0});
		if(rs)System.out.print("true");

	}

}
