package offer;

public class _array_duplicate {
	
	public static boolean duplicate(int numbers[], int length, int[] duplication) {
		if(numbers==null||numbers.length==0)return false;
		int[] cnt =new int[length];
		for (int i = 0; i < numbers.length; i++) {
			cnt[numbers[i]]++;
			if(cnt[numbers[i]]>1) { 
					duplication[0]=numbers[i];
					return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		int[] numbers= new int[] {};
		duplicate(numbers,numbers.length,new int[] {});
	}
}
