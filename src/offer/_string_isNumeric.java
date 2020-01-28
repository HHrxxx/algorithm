package offer;
/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 *
 *	一一分情况考虑即可
 */
public class _string_isNumeric {
	
    public static boolean isNumeric(char[] str) {
        if(str.length==0)return false;
       // boolean sFlag=false;
        boolean  eFlag=false;
        boolean pointFlag=false;
        for (int i = 0; i < str.length; i++) {
        	//最后一位 只能是数字
			if(i==str.length-1) {
				if(!(str[i]>='0'&&str[i]<='9'))return false;
			}
			
        	if((str[i]>='0'&&str[i]<='9')||str[i]=='.'||str[i]=='e'||str[i]=='E'||str[i]=='-'||str[i]=='+') {
        		//符号位处理
    			if(i!=0&&(str[i]=='+'||str[i]=='-')&&str[i-1]!='e'&&str[i-1]!='E'){
    				return false;//sFlag=true;
    			}
    			//小数点处理
    			if(str[i]=='.') { 
    				if(!pointFlag) {//前面没有小数点
    					if(eFlag)return false;//有 e
    					if((i+1)<str.length&&str[i+1]>='0'&&str[i+1]<='9') {
    						pointFlag=true;
    					}
    					else return false;
    				}else { 
        				return false;
        			}
    			}
    			//e
    			if(str[i]=='e'||str[i]=='E') { 
    				eFlag=true;
    			}	
        	}else {
        		return false;
        	} 	
		}       
        return true;
    }

	public static void main(String[] args) {
		//-.123        true!!!???
		if(isNumeric(("-.123").toCharArray())) {
			System.out.println("true");
		}
	}
}
