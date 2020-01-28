package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author hrx
 * @Date 2020/1/7
 * 给定一个无重复元素的数组 candidates 和一个目标数 target
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * 解法：递归
 */
public class _array_combinationSum {

    public static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        func(candidates, target, 0, 0, list);
        return ans;
    }

    public static void func(int[] candidates, int target, int curAns, int curIndex, List curList) {

        if (curAns == target) {//可以用减法处理
            ans.add(new ArrayList<>(curList));//防止地址传递，影响数据结果
            return;
        } else if (curIndex == candidates.length || curAns > target) {
            return;
        }

        for (int i = curIndex; i < candidates.length; i++) {
            int x = curAns + candidates[i];
            if (x > target) break;
            curList.add(candidates[i]);
            func(candidates, target, x, i, curList);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5};
        combinationSum(arr, 8);
        System.out.println(ans.toString());
    }
}
