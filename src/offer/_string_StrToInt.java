package offer;

/**
 * 实现Integer.valueOf(string)的功能
 * 
 * 但是string不符合数字要求时返回0
 *
 *	从尾--头，base*10 累加
 *	注意：边界情况处理
 */
public class _string_StrToInt {

    public static int StrToInt(String str) {
    	if(str.length()==0)return 0;
    	int num=0,base=1;
    	for(int i=str.length()-1;i>=0;i--) {
    		if(str.charAt(i)>='0'&&str.charAt(i)<='9') {
    			int range=Integer.MAX_VALUE;
    			int cur=base*(str.charAt(i)-'0');
    			if(str.charAt(0)=='-') {
    				range=Integer.MIN_VALUE;	
    				if((range+num)>-cur) return 0;  				
    			}else {
    				if((range-num)<cur) return 0;
    			}
    			num+=cur;
    			base=base*10;
    		}else {
    			if(i==0) {
    				if(str.charAt(0)=='+')
    					return num;
    				else if(str.charAt(0)=='-')
    					return -num;
    			}
    			return 0;
    		}
    	}
        
    	return num;
    }
    
	public static void main(String[] args) {

		System.out.println(StrToInt("-2147483648"));
		System.out.print(StrToInt("-2147483649"));
		System.out.print(StrToInt("-18646asa598"));

	}

}
