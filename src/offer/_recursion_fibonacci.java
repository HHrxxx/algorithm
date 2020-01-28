package offer;

/**
 * 斐波那契数列
 *
 */
public class _recursion_fibonacci {

	//递归 但是会有栈溢出
//	public static int Fibonacci(int n) {
//		if(n==0)return 0;
//		if(n==1)return 1;	
//		return Fibonacci(n-2)+Fibonacci(n-1);	
//    }
	public static int Fibonacci(int n) {
        int f = 0, g = 1;
      //迭代
        while(n!=0) {
            g += f; //g=f(n-1)+f(n-2)
            f = g - f;
            n--;
        }
        return f;
    }
	
	public static void main(String[] args) {
	
		System.out.print(Fibonacci(4));
	}

}
