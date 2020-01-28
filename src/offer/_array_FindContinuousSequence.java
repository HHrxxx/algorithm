package offer;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。 序列内按照从小至大的顺序， 序列间按照开始数字从小到大的顺序
 *
 *
 * 滑动窗口 2个指针
 */
public class _array_FindContinuousSequence {

	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (sum == 1 || sum == 0 || sum == 2)
			return ans;
		int p = 1;
		int next = 2;
		int s = 3;
		while (p != next) {
			if (s < sum) {
				next++;
				s += next;
			} else if (s > sum) {
				s -= p;
				p++;
			} else {
				ArrayList<Integer> rs = new ArrayList<Integer>();
				rs=getArray(p,next);
				ans.add(rs);
				next++;
				s += next;
			}
		}

		return ans;
	}

	public static ArrayList<Integer> getArray(int start, int end) {
		ArrayList<Integer> rs = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			rs.add(i);
		}
		return rs;
	}

	public static void main(String[] args) {
		FindContinuousSequence(101);

	}

}
