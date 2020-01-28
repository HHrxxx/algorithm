package leetcode;

import java.util.Stack;

public class _array_evalRPN {

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-")|| tokens[i].equals("*")|| tokens[i].equals("/")) {
				int x = Integer.valueOf(stack.pop());
				int y = Integer.valueOf(stack.pop());
				switch (tokens[i]) {
				case ("+"):
					stack.push(x + y);
					break;
				case ("-"):
					stack.push(y - x);
					break;
				case ("*"):
					stack.push(x * y);
					break;
				case ("/"):
					stack.push(y / x);
					break;
				}
			} else {
				stack.push(Integer.valueOf(tokens[i]));
			}
		}
		return Integer.valueOf(stack.pop());
	}

	public static void main(String[] args) {

		String[] s = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println(evalRPN(s));
	}

}
