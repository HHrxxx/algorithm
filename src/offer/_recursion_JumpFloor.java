package offer;

/**
 *	  	斐波那契数列 应用
 *
 */
public class _recursion_JumpFloor {


/**
 * 
 * @param target
 * @return
 */
//	public int JumpFloor(int target) {
//	        if (target <= 0) {
//	            return -1;
//	        } else if (target == 1) {
//	            return 1;
//	        } else if (target ==2) {
//	            return 2;
//	        } else {
//	            return  JumpFloor(target-1)+JumpFloor(target-2);
//	        }
//	    }
	
	
	
	public static int ans=0;
	public static int JumpFloor(int target) {
        JumpJump(0,target);
		return ans;
    }
	
	public static void JumpJump(int cnt,int target) {
        if(cnt==target)
        	ans++;
        if(cnt>target)
        	return;
        JumpJump(cnt+1,target);
        JumpJump(cnt+2, target);
    }
	public static void main(String[] args) {
		System.out.print(JumpFloor(5));
	}

}
