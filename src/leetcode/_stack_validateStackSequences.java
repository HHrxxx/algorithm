package leetcode;

import java.util.Stack;
/**
 * 	验证栈序列
 * @author John
 *
 */
public class _stack_validateStackSequences {
	
	
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		
		Stack<Integer> stack=new Stack<>();
		int m=0;

		for (int i = 0; i < pushed.length; i++) {
		
			if(!stack.isEmpty()) {
				if(popped[m]==stack.peek()) {
					stack.pop();
					m++;
					i--;
					continue;
				}
			}
				stack.push(pushed[i]);					
		}

		while(m!=popped.length) {			
			if(popped[m]==stack.peek()) {
				stack.pop();
				m++;
			}else {
				break;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		
		int[] push=new int[] {1,2,3,4,5};
		int[] pop=new int[] {4,5,3,2,1};
		System.out.println(validateStackSequences(push,pop));

	}

}
