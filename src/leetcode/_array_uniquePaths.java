package leetcode;
/**
 * 	左上角
 * 	每次只能向下或者向右移动一步，达到网格的右下角
 *
 * 	动态规划DP
 * 	先处理边界情况 i==0||j==0 这种路径只有一条
 */
public class _array_uniquePaths {

	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];      


	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 5));
	}

}
