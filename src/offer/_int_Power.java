package offer;
/**
 * 求base的exponent次方
 * 
 * 先把不合法的做判断
 * 将exponent分类 奇数、偶数
 */
public class _int_Power {
	
	public static double Power(double base, int exponent) {
        if(exponent==0)return 1;
        if(base==0)return base;
		if(exponent<0) {
			exponent=-exponent;
			return 1/Power1(base,exponent);
		}
		return Power1(base,exponent);
		
	}
	public static double Power1(double base, int exponent) {
		if(exponent==1)return base;
		double rs=Power(base, exponent/2);
		if(exponent%2==1) {
			return rs*rs*base;
		}else {
			return rs*rs;
		}

	}

	public static void main(String[] args) {
	
		System.out.print(Power(0,0));

	}

}
