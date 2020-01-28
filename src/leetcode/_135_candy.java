package leetcode;

import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 
 * 每个孩子至少分配到 1 个糖果。 相邻的孩子中，评分高的孩子必须获得更多的糖果。 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 
 */
public class _135_candy {

	public static int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;
		if (ratings.length == 1)
			return 1;

		int cnt = 1;
		int[] rs = new int[ratings.length];
		Arrays.fill(rs, 1);
		for (int i = 1; i < rs.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				rs[i] = rs[i - 1] + 1;
			}
			cnt += rs[i];
		}
		for (int i = rs.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && rs[i] <= rs[i + 1]) {
				cnt = cnt - rs[i] + rs[i + 1] + 1;
				rs[i] = rs[i + 1] + 1;
			}

		}
		System.out.println(Arrays.toString(rs));

		return cnt;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 80, 90, 99, 80, 70 };
		System.out.println(candy(arr));

	}

}
