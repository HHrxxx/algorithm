package offer;
/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子
 * 
 * 用一个visited来标识是否访问过，
 * 
 * 不用向左或向上
 * 向左的点，在回溯某个点，然后向下就访问到了
 */
public class _array_movingCount {

	static int cnt=0;
	public static int movingCount(int threshold, int rows, int cols) {
		int[][] visited = new int[rows][cols];
		moving(threshold, rows, cols, 0, 0, visited);
		return cnt;
	}

	public static void moving(int threshold, int rows, int cols, int curRow, int curCol, int[][] visited) {
		
		int sum = judge(curRow) + judge(curCol);
		if (sum <= threshold) {
			visited[curRow][curCol]=1;
			cnt++;
			// 向右一步
			if ((curCol + 1) < cols && visited[curRow][curCol + 1] != 1) {
				moving(threshold, rows, cols, curRow, curCol + 1,visited);
			}
			//向下一步
			if ((curRow + 1) < rows && visited[curRow+1][curCol] != 1) {
				moving(threshold, rows, cols, curRow+1, curCol,visited);
			}			
		}

	}

	public static int judge(int num) {
		int s = 0;
		while (num / 10 != 0) {
			s += num % 10;
			num = num / 10;
		}
		s += num;
		return s;
	}

	public static void main(String[] args) {
		System.out.print(movingCount(3, 4, 4));
//		System.out.print(judge(35));
	}

}
