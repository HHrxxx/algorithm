package offer;

public class _bitOperation_NumberOf1Between1AndN_Solution {

    public static int NumberOf1Between1AndN_Solution(int n) {
    	int cnt=0,base=1;
    	int left,cur,right;
    	while(n/base!=0) {
		  right =n-(n/base) *base; 
          left = n/(base * 10);
          cur = (n/base) % 10;
          switch(cur) {
          	case(0):{
          		cnt+=left*base;
          		break;
          	}
          	case(1):{
          		cnt+=left*base+right+1;
          		break;
          	}
          	default:{
          		cnt+=left*base+base;
          	}
          }
          base*=10;
    	}
        return cnt;
    }
    
	public static void main(String[] args) {
		System.out.print(NumberOf1Between1AndN_Solution(11));

	}

}
