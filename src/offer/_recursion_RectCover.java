package offer;
/**
 * 		n个2*1的小矩形无重叠地覆盖一个2*n的大矩形
 *  	斐波那契数列应用
 *	n
 *	1(1)	|
 *	2(2)	=、||
 *	3(3)	|=、=|、|||
 *	4(5)	|=|、==、||=、=||、||||
 *	5(8)	|==、==|、||=|、|=||、|||=、=|||、|||||、=|=
 */
public class _recursion_RectCover {

	public static int RectCover(int target) {
		if(target==0)return 0;
		if(target==1) {
			return 1;		
		}else if(target==2){
			return 2;
		}else {
			return RectCover(target-1)+RectCover(target-2);
		}	
    }
	
	public static void main(String[] args) {
		
		System.out.print(RectCover(5));
	}

}
