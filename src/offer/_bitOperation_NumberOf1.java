package offer;

import java.util.Scanner;

/**
 * 输出该数二进制表示中1的个数。其中负数用补码表示
 *
 *	反码：原码符号位不变，其余取反
 *	补码(负数)：反码+1
 *	补码(负数)：原码，低位开始找到第一个1，保持不变，之后按位取反，符号位不变
 *
 *	本题用第二种，取负数补码
 *
 */
public class _bitOperation_NumberOf1 {

	public static int NumberOf1(int n) {
		if(n==-2147483648)return 1;
		char[] rs=binaryNumber(n).toCharArray();
		int cnt=0;
		boolean flag=false;
		if(n<0) {
			for(int i=rs.length-1;i>=0;i--) {
				if(flag) {
					rs[i]=rs[i]=='1'?'0':'1';
				}
				if(rs[i]=='1'&&!flag)
					flag=true;
			}
		}	
	
		for(int i=rs.length-1;i>=0;i--) {
			if(rs[i]=='1')cnt++;
		}
		if(n<0)cnt++;
		return cnt;
	}
	
	public static String binaryNumber(int n) {
		if(n<0) n=-n;
		String rs="";		
		while(n/2!=0) {
			rs=String.valueOf(n%2)+rs;
			n=n/2;
		}
		rs=String.valueOf(n%2)+rs;
		while(rs.length()!=31) {
			rs="0"+rs;
		}
		return rs;			
	}

    //--------------------最优解----------------------------
//	例子：二进制数1100，
//	从右边数起第三位是处于最右边的一个1。
//	减去1后，第三位变成0，它后面的两位0变成了1  (1011)
//	把原来的整数和减去1之后的结果做与运算
//	把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0
//	那么一个整数的二进制有多少个1，就可以进行多少次这样的操作
    public static int NumberOf(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
	public static void main(String[] args) {
		//System.out.println(NumberOf1(214));
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		System.out.println(NumberOf(n));
	}

}
