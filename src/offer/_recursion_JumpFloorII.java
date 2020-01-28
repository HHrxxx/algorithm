package offer;

public class _recursion_JumpFloorII {


//	public class Solution {
//	    public int JumpFloorII(int target) {
//	        if (target <= 0) {
//	            return -1;
//	        } else if (target == 1) {
//	            return 1;
//	        } else {
//	            return 2 * JumpFloorII(target - 1);
//	        }
//	    }
//	}
	
	
	public static int ans=0;
	public static int JumpFloorII(int target) {
        JumpJump(0,target);
		return ans;
    }
	
	public static void JumpJump(int cnt,int target) {
        if(cnt==target)
        	ans++;
        if(cnt>target)
        	return;
        for(int i =1;i<=target;i++) {
        	if(cnt+i>target)break;
        	 JumpJump(cnt+i,target);
        }
    }
	public static void main(String[] args) {
		System.out.print(JumpFloorII(3));
	}

}
