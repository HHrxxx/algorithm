package offer;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符
 * 
 * LinkedHashMap 插入--顺序--有序  内部维持了一个双向链表
 * hashMap 插入--字典序--有序
 *
 */
public class _string_FirstAppearingOnce {
	
	static Map<Character,Integer> map=new LinkedHashMap<Character,Integer>();
    public static void Insert(char ch)
    {
        if(map.containsKey(ch)) {
        	map.put(ch, map.get(ch)+1);
        }
        else {
        	map.put(ch,1);
        }
    }
  //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce(){
    	for (Map.Entry<Character, Integer> entry : map.entrySet()) { 
    		if(entry.getValue()==1) return entry.getKey();
    	}
    	return '#';
    }

	public static void main(String[] args) {
		Insert('g');
		Insert('o');
		Insert('o');
		Insert('g');
		Insert('l');
		Insert('e');
		System.out.print(FirstAppearingOnce());
	}

}
