package leetcode;

/**
 * 第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。
 *
 */
public class _int_bulbSwitch {

	//超时
	public static int bulbSwitch(int n) {
		int[] bulb=new int[n+1];
		for (int i = 1; i <=n ; i++) {
			for (int j = i; j <bulb.length ; j+=i) {
				bulb[j]=bulb[j]==0?1:0;
			}
		}
		int cnt=0;
		for (int i = 1; i <bulb.length; i++) {
			if(bulb[i]==1)cnt++;
		}
		return cnt;
	}
	public static int bulbSwitch2(int n) {
		
		return (int)Math.sqrt(n);
	}

	public static void main(String[] args) {
		System.out.println(bulbSwitch2(10000000));
	}

}
