package offer;

import java.util.ArrayList;
/**
 * 	按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 	1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 	打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 *
 */
public class _array_printMatrix {

	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> rs=new  ArrayList<Integer>();
		int colLength=matrix[0].length;
		int rowLength=matrix.length;
		int cntAll=colLength*rowLength;
		int cnt=0,r=0,c=0,loop=0;
		while(cnt<cntAll) {
			while(c!=colLength&&cnt<cntAll) {
				rs.add(matrix[r][c]);
				c++;cnt++;
			}
			r++;
			c--;
			while(r!=rowLength&&cnt<cntAll) {
				rs.add(matrix[r][c]);
				r++;cnt++;
			}
			c--;
			r--;
			while(c!=loop-1&&cnt<cntAll) {
				rs.add(matrix[r][c]);
				c--;cnt++;
			}
			c++;
			r--;
			while(r!=loop&&cnt<cntAll) {
				rs.add(matrix[r][c]);
				r--;cnt++;
			}
			r++;c++;
			loop++;
			colLength--;
			rowLength--;
		}
		return rs;
	}

	public static void main(String[] args) {
		printMatrix(new int[][] {{1}});
	}

}
