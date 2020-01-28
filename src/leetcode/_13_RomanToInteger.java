package leetcode;

/**
 * 
 *	考虑各种情况
 *
 */

public class _13_RomanToInteger {

	public static int romanToInt(String s) {

		int rs=0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
				case ('I'): {
					if(i+1 < s.length()&&s.charAt(i+1)=='V') {
						rs+=4;i++;
					}else if(i+1 < s.length()&&s.charAt(i+1)=='X') {
						rs+=9;i++;
					}else {		
						rs++;
						while(i+1 < s.length()&&s.charAt(i+1)=='I') {
							rs++;
							i++;
						}
					}
					break;
				}
				case ('V'): {
					rs+=5;
					while(i+1 < s.length()&&s.charAt(i+1)=='I') {//可以省略
						rs++;
						i++;
					}
					break;
				}
				case ('X'): {
					if(i+1 < s.length()&&s.charAt(i+1)=='L') {
						rs+=40;i++;
					}else if(i+1 < s.length()&&s.charAt(i+1)=='C') {
						rs+=90;i++;
					}else {		
						rs+=10;
						while(i+1 < s.length()&&s.charAt(i+1)=='X') {
							rs+=10;
							i++;
						}
					}
					break;
				}
				case ('L'): {
					rs+=50;
					while(i+1 < s.length()&&s.charAt(i+1)=='X') {
						rs+=10;
						i++;
					}
					break;
				}
				case ('C'): {
					if(i+1 < s.length()&&s.charAt(i+1)=='D') {
						rs+=400;i++;
					}else if(i+1 < s.length()&&s.charAt(i+1)=='M') {
						rs+=900;i++;
					}else {		
						rs+=100;
						while(i+1 < s.length()&&s.charAt(i+1)=='C') {
							rs+=100;
							i++;
						}
					}
					break;
				}
				case ('D'): {
					rs+=500;
					while(i+1 < s.length()&&s.charAt(i+1)=='C') {
						rs+=100;
						i++;
					}
					break;
				}
				case ('M'): {
					rs+=1000;
					while(i+1 < s.length()&&s.charAt(i+1)=='M') {
						rs+=1000;
						i++;
					}		
					break;
				}
			}
		}

		return rs;
	}

	public static void main(String[] args) {

		System.out.println(romanToInt("MMMCMXCIX"));
	}

}
