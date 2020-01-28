package leetcode;

public class _12_IntegerToRoman {

	public static String intToRoman(int num) {
		String [][]rs= {
				{"","I","II","III","IV","V","VI","VII","VIII","IX"},
				{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
				{"","C","CC","CCCC","CD","D","DC","DCC","DCCC","CM"},
				{"","M","MM","MMM"},
		};
		String result=""; 
		int x=0;
		while(num!=0) {
			result=rs[x][num%10]+result;
			num=num/10;
			x++;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(intToRoman(3999));
	}
}
