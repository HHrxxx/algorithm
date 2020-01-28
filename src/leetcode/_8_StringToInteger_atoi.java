package leetcode;

/**
 * 	字符串转换成整数
 *	
 *	考虑各种情况 遍历即可
 */
public class _8_StringToInteger_atoi {

    public static int myAtoi(String str) {
        char []c=str.toCharArray();
        boolean flag=false;
        String rs="";
        for(int i=0;i<str.length();i++) {
        	if(c[i]==' '&&!flag)continue;
        	if((c[i]=='+'||c[i]=='-')&&!flag) {
        		if((i+1)<str.length()&&c[i+1]>='0'&&c[i+1]<='9') {
        			flag=true;
        			rs+=c[i];
        		}else break;
        	}else if(c[i]>='0'&&c[i]<='9') {
        		flag=true;
        		rs+=c[i];
        	}else {
        		break;
        	} 	        	
        }
        if(flag) {
           try {
        	   return Integer.valueOf(rs);
			} catch (Exception e) {
				if(rs.charAt(0)=='-') {
					return -2147483648;
				}else {
					return 2147483647;
				}	
			}
        }
        else return 0;
    }
    
	public static void main(String[] args) {	
		System.out.println(myAtoi("0-1"));//print:0
		System.out.println(myAtoi("-13+8"));//print:-13
//		System.out.println(myAtoi("4193 with words"));
//		System.out.println(myAtoi("words and 987"));
		System.out.println(myAtoi("   +0 123"));//print:0
		
	}

}
