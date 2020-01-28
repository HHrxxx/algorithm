package offer;

import java.util.ArrayList;

/**
 * 从小到大的顺序的第N个丑数 丑数:只包含质因子2、3和5的数
 * 
 * 判断方法1（超时）：首先除2，直到不能整除为止， 然后除5到不能整除为止，然后除3直到不能整除为止。 最终判断剩余的数字是否为1，如果是1则为丑数，否则不是丑数
 * 
 * 判断方法2:用队列，及3个指针，每次取最小
 *
 */
public class _array_GetUglyNumber_Solution {
	// 超时
	public static int GetUglyNumber_Solution(int index) {
		int cnt = 6;
		if (index < 7)
			return index;
		for (int i = 8; i < Integer.MAX_VALUE; i++) {
			int num = i;

			while (num % 2 == 0) {
				num = num / 2;
			}
			while (num % 5 == 0) {
				num = num / 5;
			}
			while (num % 3 == 0) {
				num = num / 3;
			}
			if (num == 1)
				cnt++;
			if (cnt == index)
				return i;
		}
		return 0;

	}

	public static int GetUglyNumber_Solution2(int index) {
		if (index <=0)
			return 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		int i2 = 0, i3 = 0, i5 = 0;
		while (list.size() < index) {
			int n2 = list.get(i2) * 2;
			int n3 = list.get(i3) * 3;
			int n5 = list.get(i5) * 5;
			int min = Math.min(n2, Math.min(n3, n5));
			list.add(min);
			if (min == n2)
				i2++;
			if (min == n3)
				i3++;
			if (min == n5)
				i5++;
		}
		return list.get(list.size() - 1);
	}

	public static void main(String[] args) {
		System.out.print(GetUglyNumber_Solution2(20));
	}

}
