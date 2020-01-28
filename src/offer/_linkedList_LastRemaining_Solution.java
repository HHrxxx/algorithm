package offer;

import java.util.ArrayList;

/**
 * 约瑟夫环问题
 *
 */
public class _linkedList_LastRemaining_Solution {
	//复杂度过大
	public static int LastRemaining_Solution(int n, int m) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int cnt=0;
		int i=-1;
		while(list.size()!=1) {
			i++;
			cnt++;
			if(cnt==m) {
				list.remove(i);
				i--;
				cnt=0;
			}
			if(i==list.size()-1)i=-1;
		}		
		return list.get(0);
	}
	//ac
	public static int LastRemaining_Solution1(int n, int m) {
		if(n==0||m==0)return -1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int idx=0;
		while(list.size()!=1) {
			idx=(idx+m-1)%list.size();
			list.remove(idx);
		}
		return list.get(0);
	}



	public static void main(String[] args) {

		System.out.println(LastRemaining_Solution(6, 1));
		System.out.print(LastRemaining_Solution1(6, 1));
	}

}
