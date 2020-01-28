package offer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。 不能使用除法
 *
 * 以对角线为界，分别记录上下部分的乘积 最后构建乘积数组
 */
public class _array_multiply {

	public static int[] multiply(int[] A) {
		
		int[] arr1 = new int[A.length];
		int[] arr2 = new int[A.length];
		int[] B = new int[A.length];
		
		if(A.length==0)return B;
		
		int j=A.length-1;
		int m=1;
		//记录上三角部分 倒着遍历
		for (int i = A.length - 2; i >= 0; i--,j--) {
			m*=A[j];
			arr1[i]=m;
		}
		m=1;j=0;
		//记录下三角部分 正序遍历
		for (int i = 1; i <A.length; i++,j++) {
			m*=A[j];
			arr2[i]=m;
		}
		//构建乘积数组
		for (int i = 0; i < B.length; i++) {
			if(i==0) {
				B[i]=arr1[0];
			}else if(i==A.length-1) {
				B[i]=arr2[i];
			}else {
				B[i]=arr1[i]*arr2[i];
			}
		}
		return B;
	}

	public static void main(String[] args) {
		multiply(new int[] { 1, 2, 3 ,4});

	}

}
