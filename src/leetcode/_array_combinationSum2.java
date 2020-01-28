package leetcode;

import java.util.*;

/**
 * @Author hrx
 * @Date 2020/1/7
 * 给定一个数组 candidates 和一个目标数 target
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 解法：//只用一次
 * 1、用set集合进行处理
 * 2、用while处理中间重复的数，越过去，接着算后面的结果即可（效率高
 */
public class _array_combinationSum2 {

    public static List<List<Integer>> ans = new ArrayList<>();
    // public static Set<List> setAns = new HashSet<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        func(candidates, target, 0, 0, list);
        return ans;
    }

    public static void func(int[] candidates, int target, int curAns, int curIndex, List curList) {

        if (curAns == target) {//&& !setAns.contains(curList)) {
            ans.add(new ArrayList<>(curList));
            //setAns.add(new ArrayList<>(curList));
            return;
        } else if (curIndex == candidates.length || curAns > target) {
            return;
        }

        for (int i = curIndex; i < candidates.length; i++) {
            int x = curAns + candidates[i];
            if (x > target) break;
            curList.add(candidates[i]);
            func(candidates, target, x, i + 1, curList);
            curList.remove(curList.size() - 1);
            //用while处理，越过中间重复的数
            while ((i + 1 < candidates.length) && candidates[i] == candidates[i + 1]) i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1,1,1,1,1};
        combinationSum2(arr, 4);
        System.out.println(ans.toString());
    }
}
