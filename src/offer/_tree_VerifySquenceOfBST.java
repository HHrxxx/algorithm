package offer;

/**
 *	 该数组是不是某二叉搜索树的后序遍历的结果。 如果是则输出Yes,否则输出No
 *
 * 	递归 注意单支的情况 后序序列，
 * 	最后一个为根节点，进行左右划分 data[end]用作基准寻找一个点，左小右大，
 * 	将数组分为两段 再次递归。
 */
public class _tree_VerifySquenceOfBST {

	public static boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length == 0)
			return false;
		return judge2(sequence, 0, sequence.length - 1);
	}

	public static boolean judge(int[] data, int startIdx, int endIdx) {
		if (startIdx >= endIdx)
			return true;
		int s = startIdx, cnt = 0;
		boolean flag = true;
		for (int i = startIdx; i < endIdx - 1; i++) {
			if (flag && data[i] > data[endIdx])
				cnt++;
			if (data[i] < data[endIdx] && data[i + 1] > data[endIdx] && flag) {
				flag = false;
				startIdx = i;
				continue;
			}
			if (!flag) {
				if (data[i] < data[endIdx])
					return false;
			}
		}
		if (!flag && cnt > 0)
			return false;// {7,4,6,5}
		if (!flag) {// 左单支情况
			return judge(data, s, startIdx - 1);
		} else {
			return judge(data, s, startIdx) && judge(data, startIdx + 1, endIdx - 1);
		}
	}

	// 改进版
	public static boolean judge2(int[] data, int start, int end) {
		if (start >= end)
			return true;

		int i = end;// 从尾向前找 小于end的数
		while (i > start && data[i] > data[end])
			i--;
		
		for (int j = start; j < i - 1; j++)
			if (data[j] > data[end])// 从头找 若有大于data[end] 则false
				return false;

		return judge2(data, start, i - 1) && judge2(data, i, end - 1);
	}

	public static void main(String[] args) {

		if (VerifySquenceOfBST(new int[] { 1, 2, 3, 4 })) {
			System.out.println("Yes");
		}
	}

}
