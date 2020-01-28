package offer;

import java.util.Stack;

/**
 * 第一个序列表示栈的压入顺序， 请判断第二个序列是否可能为该栈的弹出顺序
 * 
 * stack 不为空，对比一次peek，否则push
 * 最后return cnt是否等于length即可
 * 
 * 注意数组边界情况
 */
public class _stack_IsPopOrder {

	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> stack = new Stack<Integer>();
		int j = 0, i = 0;
		int cnt = 0;
		while (j < pushA.length && i < popA.length) {
			if (!stack.isEmpty() && stack.peek() == popA[i]) {
				stack.pop();
				i++;
				cnt++;
				continue;
			}
			if (pushA[j] != popA[i]) {
				stack.push(pushA[j]);
			} else {
				i++;
				cnt++;
			}
			j++;
		}
		while (!stack.isEmpty() && i < popA.length) {
			if (stack.pop() == popA[i++])
				cnt++;
		}

		return cnt == popA.length ? true : false;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = {3,5,4,2,1 };
		IsPopOrder(arr1, arr2);

	}

}
